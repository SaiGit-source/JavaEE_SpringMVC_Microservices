package com.safebank.ledgerapi.account.service;

import com.safebank.ledgerapi.account.dto.*;
import com.safebank.ledgerapi.account.entity.*;
import com.safebank.ledgerapi.account.repository.AccountRepository;
import com.safebank.ledgerapi.account.repository.LedgerEntryRepository;
import com.safebank.ledgerapi.common.error.BadRequestException;
import com.safebank.ledgerapi.common.error.ConflictException;
import com.safebank.ledgerapi.common.error.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final LedgerEntryRepository ledgerEntryRepository;

    public AccountService(AccountRepository accountRepository, LedgerEntryRepository ledgerEntryRepository) {
        this.accountRepository = accountRepository;
        this.ledgerEntryRepository = ledgerEntryRepository;
    }
    
    public List<AccountEntity> getAllAccounts() {
		return accountRepository.findAll();
	}

    public List<AccountResponse> getAccounts(String name) {
        List<AccountEntity> accounts = name == null || name.isBlank()
                ? accountRepository.findAll()
                : accountRepository.findByAccountHolderNameContainingIgnoreCase(name);

        return accounts.stream().map(this::toAccountResponse).toList();
    }

    public AccountResponse getAccount(String accountNumber) {
        return toAccountResponse(findAccount(accountNumber));
    }

    @Transactional
    public AccountResponse createAccount(CreateAccountRequest request) {
        if (accountRepository.existsByAccountNumber(request.accountNumber())) {
            throw new ConflictException("Account number already exists: " + request.accountNumber());
        }

        AccountEntity account = new AccountEntity(
                request.accountNumber(),
                request.accountHolderName(),
                request.email(),
                request.currency().toUpperCase(),
                request.openingBalance()
        );

        AccountEntity saved = accountRepository.save(account);

        if (request.openingBalance().compareTo(BigDecimal.ZERO) > 0) {
            recordEntry(saved, TransactionType.DEPOSIT, request.openingBalance(), null, "Opening balance");
        }

        return toAccountResponse(saved);
    }

    @Transactional
    public AccountResponse updateAccount(String accountNumber, UpdateAccountRequest request) {
        AccountEntity account = findAccount(accountNumber);
        ensureActive(account);

        account.setAccountHolderName(request.accountHolderName());
        account.setEmail(request.email());

        return toAccountResponse(accountRepository.save(account));
    }

    @Transactional
    public AccountResponse deposit(String accountNumber, MoneyMovementRequest request) {
        AccountEntity account = findAccount(accountNumber);
        ensureActive(account);

        BigDecimal newBalance = account.getBalance().add(request.amount());
        account.setBalance(newBalance);

        AccountEntity saved = accountRepository.save(account);
        recordEntry(saved, TransactionType.DEPOSIT, request.amount(), null, request.description());

        return toAccountResponse(saved);
    }

    @Transactional
    public AccountResponse withdraw(String accountNumber, MoneyMovementRequest request) {
        AccountEntity account = findAccount(accountNumber);
        ensureActive(account);
        ensureSufficientFunds(account, request.amount());

        BigDecimal newBalance = account.getBalance().subtract(request.amount());
        account.setBalance(newBalance);

        AccountEntity saved = accountRepository.save(account);
        recordEntry(saved, TransactionType.WITHDRAWAL, request.amount(), null, request.description());

        return toAccountResponse(saved);
    }

    @Transactional
    public List<AccountResponse> transfer(TransferRequest request) {
        if (request.fromAccountNumber().equals(request.toAccountNumber())) {
            throw new BadRequestException("Cannot transfer to the same account");
        }

        AccountEntity from = findAccount(request.fromAccountNumber());
        AccountEntity to = findAccount(request.toAccountNumber());
        ensureActive(from);
        ensureActive(to);

        if (!from.getCurrency().equals(to.getCurrency())) {
            throw new BadRequestException("Currency mismatch between accounts");
        }

        ensureSufficientFunds(from, request.amount());

        from.setBalance(from.getBalance().subtract(request.amount()));
        to.setBalance(to.getBalance().add(request.amount()));

        AccountEntity savedFrom = accountRepository.save(from);
        AccountEntity savedTo = accountRepository.save(to);

        recordEntry(savedFrom, TransactionType.TRANSFER_OUT, request.amount(), to.getAccountNumber(), request.description());
        recordEntry(savedTo, TransactionType.TRANSFER_IN, request.amount(), from.getAccountNumber(), request.description());

        return List.of(toAccountResponse(savedFrom), toAccountResponse(savedTo));
    }

    public List<LedgerEntryResponse> getLedger(String accountNumber) {
        findAccount(accountNumber);
        return ledgerEntryRepository.findByAccountNumberOrderByCreatedAtDesc(accountNumber)
                .stream()
                .map(this::toLedgerResponse)
                .toList();
    }

    @Transactional
    public void closeAccount(String accountNumber) {
        AccountEntity account = findAccount(accountNumber);
        if (account.getBalance().compareTo(BigDecimal.ZERO) != 0) {
            throw new BadRequestException("Account balance must be zero before closing");
        }
        account.setStatus(AccountStatus.CLOSED);
        accountRepository.save(account);
    }
    
    
    @Transactional
    public void removeAccountEntry(String accountNumber) {
        AccountEntity account = findAccount(accountNumber);
        accountRepository.delete(account);
    }


    public AccountEntity findAccount(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new NotFoundException("Account not found: " + accountNumber));
    }

    public void ensureActive(AccountEntity account) {
        if (account.getStatus() != AccountStatus.ACTIVE) {
            throw new BadRequestException("Account is not active: " + account.getAccountNumber());
        }
    }

    private void ensureSufficientFunds(AccountEntity account, BigDecimal amount) {
        if (account.getBalance().compareTo(amount) < 0) {
            throw new BadRequestException("Insufficient funds for account: " + account.getAccountNumber());
        }
    }

    private void recordEntry(
            AccountEntity account,
            TransactionType type,
            BigDecimal amount,
            String relatedAccountNumber,
            String description
    ) {
        ledgerEntryRepository.save(new LedgerEntryEntity(
                account.getAccountNumber(),
                type,
                amount,
                account.getBalance(),
                relatedAccountNumber,
                description
        ));
    }

    private AccountResponse toAccountResponse(AccountEntity account) {
        return new AccountResponse(
                account.getId(),
                account.getAccountNumber(),
                account.getAccountHolderName(),
                account.getEmail(),
                account.getCurrency(),
                account.getBalance(),
                account.getStatus(),
                account.getCreatedAt()
        );
    }

    private LedgerEntryResponse toLedgerResponse(LedgerEntryEntity entry) {
        return new LedgerEntryResponse(
                entry.getId(),
                entry.getAccountNumber(),
                entry.getType(),
                entry.getAmount(),
                entry.getResultingBalance(),
                entry.getRelatedAccountNumber(),
                entry.getDescription(),
                entry.getCreatedAt()
        );
    }
}
