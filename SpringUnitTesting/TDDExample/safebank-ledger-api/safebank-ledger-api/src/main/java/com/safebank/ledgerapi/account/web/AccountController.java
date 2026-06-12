package com.safebank.ledgerapi.account.web;

import com.safebank.ledgerapi.account.dto.*;
import com.safebank.ledgerapi.account.service.AccountService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<AccountResponse> getAccounts(@RequestParam(required = false) String name) {
        return accountService.getAccounts(name);
    }

    @GetMapping("/{accountNumber}")
    public AccountResponse getAccount(@PathVariable String accountNumber) {
        return accountService.getAccount(accountNumber);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AccountResponse createAccount(@Valid @RequestBody CreateAccountRequest request) {
        return accountService.createAccount(request);
    }

    @PutMapping("/{accountNumber}")
    public AccountResponse updateAccount(
            @PathVariable String accountNumber,
            @Valid @RequestBody UpdateAccountRequest request
    ) {
        return accountService.updateAccount(accountNumber, request);
    }

    @PostMapping("/{accountNumber}/deposit")
    public AccountResponse deposit(
            @PathVariable String accountNumber,
            @Valid @RequestBody MoneyMovementRequest request
    ) {
        return accountService.deposit(accountNumber, request);
    }

    @PostMapping("/{accountNumber}/withdraw")
    public AccountResponse withdraw(
            @PathVariable String accountNumber,
            @Valid @RequestBody MoneyMovementRequest request
    ) {
        return accountService.withdraw(accountNumber, request);
    }

    @PostMapping("/transfer")
    public List<AccountResponse> transfer(@Valid @RequestBody TransferRequest request) {
        return accountService.transfer(request);
    }

    @GetMapping("/{accountNumber}/ledger")
    public List<LedgerEntryResponse> getLedger(@PathVariable String accountNumber) {
        return accountService.getLedger(accountNumber);
    }

    @DeleteMapping("/{accountNumber}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void closeAccount(@PathVariable String accountNumber) {
        accountService.closeAccount(accountNumber);
    }
    
    
    /**
     * Extracts the "userEmail" attribute that was previously attached 
     * to the HTTP request by an upstream filter or interceptor.
     */
    @GetMapping("/profile")
    public String getProfileContext(@RequestAttribute("userEmail") String email) {
        // Business logic running against the secure request attribute
        return "Secure session active for account user: " + email;
    }
    
    
    @GetMapping("/profile1")
    public ResponseEntity<String> getProfileWithEntity(HttpServletRequest request) {
        // 1. Pull the attribute out of the incoming request
        String email = (String) request.getAttribute("userEmail");
        
        // 2. Wrap it inside a standard ResponseEntity container
        return ResponseEntity.ok()
                .header("X-Account-Context", "Verified")
                .body("Active Account Profile for: " + email);
    }
    
}
