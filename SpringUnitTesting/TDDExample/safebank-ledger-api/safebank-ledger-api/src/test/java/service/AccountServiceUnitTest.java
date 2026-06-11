package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.safebank.ledgerapi.account.dto.AccountResponse;
import com.safebank.ledgerapi.account.dto.CreateAccountRequest;
import com.safebank.ledgerapi.account.dto.UpdateAccountRequest;
import com.safebank.ledgerapi.account.entity.AccountEntity;
import com.safebank.ledgerapi.account.repository.AccountRepository;
import com.safebank.ledgerapi.account.repository.LedgerEntryRepository;
import com.safebank.ledgerapi.account.service.AccountService;
import com.safebank.ledgerapi.common.error.ConflictException;
import com.safebank.ledgerapi.common.error.NotFoundException;

@ExtendWith(MockitoExtension.class)
public class AccountServiceUnitTest {
	
	@InjectMocks
	AccountService accountService;
	
	// we need to mock the dependencies of AccountService, such as AccountRepository, TransactionRepository, etc.
	
	@Mock
	AccountRepository accountRepository;
	
	@Mock
	LedgerEntryRepository ledgerEntryRepository;
	
	@Test
	void getAllAccounts_ShouldReturnListOfAccounts() {
		// pass in the number of elements we want to create / return from the mock repository getMockAccounts(2)
			Mockito.doReturn(getMockAccounts(2)).when(accountRepository).findAll();
			List<AccountEntity> accounts = this.accountService.getAllAccounts();
			assert(accounts.size() == 2);
		}
	
	private Iterable<AccountEntity> getMockAccounts(int count) {
		List<AccountEntity> accounts = new ArrayList<>(count);
		for (long i = 0; i < count; i++) {
			AccountEntity account = new AccountEntity("ACC" + i, "Account_Holder " + i, "account" + i + "@example.com", "CAD", BigDecimal.valueOf(1000));
			accounts.add(account);
		}
		
		return accounts;
	}
	
	private AccountEntity getMockAccountEntity() {
		AccountEntity account = new AccountEntity("ACC123", "testFirst", "testEmail@rmail.com", "CAD", BigDecimal.valueOf(2000));		
		return account;
	}

	
	@Test
	void getAccount_ReturnsAccount() {
		AccountEntity account = getMockAccountEntity();
		Optional<AccountEntity> optionalAccount = Optional.of(account);
		Mockito.doReturn(optionalAccount).when(accountRepository).findByAccountNumber(account.getAccountNumber().toString());
		AccountResponse result = accountService.getAccount(account.getAccountNumber().toString());
		assertNotNull(result);
		assertEquals("testFirst", result.accountHolderName());
	}

	
	@Test
	void getAccount_NotExists() {
		AccountEntity account = getMockAccountEntity();
		Optional<AccountEntity> optionalAccount = Optional.empty();
		Mockito.doReturn(optionalAccount).when(accountRepository).findByAccountNumber("ACC123");
		assertThrows(NotFoundException.class, () -> accountService.getAccount(account.getAccountNumber()).toString());
	}
	
	
	@Test
	void addAccount_ShouldCreateAccount() {
		AccountEntity account = getMockAccountEntity();
		when(accountRepository.existsByAccountNumber(account.getAccountNumber())).thenReturn(false); // it compares with line 45 in AccountService.java, where it checks if the account number already exists in the repository
		when(accountRepository.save(Mockito.any(AccountEntity.class))).thenReturn(account); // line 57 in AccountService.java, where it saves the new account to the repository and returns the saved account entity
// so far setting up Mockito to return the expected values when the AccountService calls the repository methods. Now we can call the createAccount method and assert the results.

		account = new AccountEntity(account.getAccountNumber(), account.getAccountHolderName(), account.getEmail(), account.getCurrency(), account.getBalance());
		CreateAccountRequest request = new CreateAccountRequest(account.getAccountNumber(), account.getAccountHolderName(), account.getEmail(), account.getCurrency(), account.getBalance());
		AccountResponse result = accountService.createAccount(request);
		assertNotNull(result);
		assertEquals("testFirst", result.accountHolderName());
	}
	
	
	@Test
	void addAccount_existing() {
		AccountEntity account = getMockAccountEntity();
		lenient().when(accountRepository.existsByAccountNumber(account.getAccountNumber())).thenReturn(true); // it compares with line 45 in AccountService.java, where it checks if the account number already exists in the repository
		lenient().when(accountRepository.save(Mockito.any(AccountEntity.class))).thenReturn(account); // line 57 in AccountService.java, where it saves the new account to the repository and returns the saved account entity
// so far setting up Mockito to return the expected values when the AccountService calls the repository methods. Now we can call the createAccount method and assert the results.

		account = new AccountEntity(account.getAccountNumber(), account.getAccountHolderName(), account.getEmail(), account.getCurrency(), account.getBalance());
		CreateAccountRequest request = new CreateAccountRequest(account.getAccountNumber(), account.getAccountHolderName(), account.getEmail(), account.getCurrency(), account.getBalance());
		assertThrows(ConflictException.class, () -> accountService.createAccount(request));
	}
	
	@Test
	void updateAccount_Success() {
		AccountEntity account = getMockAccountEntity();
		//lenient().when(accountService.findAccount(account.getAccountNumber())).thenReturn(account);
		lenient().when(accountRepository.findByAccountNumber(account.getAccountNumber())).thenReturn(Optional.of(account));
		//when(accountService.ensureActive(account)).thenReturn(Optional.empty());
		lenient().when(accountRepository.save(Mockito.any(AccountEntity.class))).thenReturn(account); // line 57 in AccountService.java, where it saves the new account to the repository and returns the saved account entity
		
		UpdateAccountRequest request = new UpdateAccountRequest("testUpdate", "testEmail@rmail.com");
		account = new AccountEntity(account.getAccountNumber(), account.getAccountHolderName(), account.getEmail(), account.getCurrency(), account.getBalance()); 
		AccountResponse result = accountService.updateAccount(account.getAccountNumber(), request);
		assertNotNull(result);
		assertEquals("testUpdate", result.accountHolderName());
	}
	

		
	

}
