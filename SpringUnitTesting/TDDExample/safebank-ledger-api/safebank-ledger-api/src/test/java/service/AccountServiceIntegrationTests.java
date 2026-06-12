package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import com.safebank.ledgerapi.account.dto.AccountResponse;
import com.safebank.ledgerapi.account.dto.CreateAccountRequest;
import com.safebank.ledgerapi.account.dto.UpdateAccountRequest;
import com.safebank.ledgerapi.account.entity.AccountEntity;
import com.safebank.ledgerapi.account.service.AccountService;
import com.safebank.ledgerapi.common.error.ConflictException;
import com.safebank.ledgerapi.common.error.NotFoundException;

import io.micrometer.common.util.StringUtils;

// instead of mocking, we will use the Embedded database H2, and we are running the actual seed .sql scripts on H2
@SpringBootTest(classes = com.safebank.ledgerapi.LedgerApiApplication.class)
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.properties")
//@AutoConfigureTestDatabase(replace=Replace.ANY) //Not working for some reasons 
public class AccountServiceIntegrationTests {
	
	@Autowired
	AccountService service;
	
	@Test
	void getAllAccount_Success() {
		List<AccountEntity> accounts = this.service.getAllAccounts();
		assertEquals(5, accounts.size());
	}
	
	@Test
	void getAccount() {
		AccountResponse account = this.service.getAccount("SB-100001");
		assertNotNull(account);
		assertEquals("Chris Miller", account.accountHolderName());
	}
	
	@Test
	void getAccount_NotFound() {
		assertThrows(NotFoundException.class, () -> this.service.getAccount("SB-100010"));
	}
	
	@Test
	void addAccount() {
		AccountEntity account = new AccountEntity("ACC123", "testFirst", "testEmail@rmail.com", "CAD", BigDecimal.valueOf(2310));
		CreateAccountRequest request = new CreateAccountRequest(account.getAccountNumber(), account.getAccountHolderName(), account.getEmail(), account.getCurrency(), account.getBalance());
		AccountResponse result = this.service.createAccount(request);
		assertTrue(StringUtils.isNotBlank(account.getAccountHolderName()));
		assertNotNull(result);
		assertEquals("testFirst", result.accountHolderName());
		this.service.removeAccountEntry(account.getAccountNumber()); // cleanup before other tests
	}
	
	
	@Test
	void addAccount_AlreadyExists() {
		AccountEntity account = new AccountEntity("ACC123", "testFirst", "testEmail@rmail.com", "CAD", BigDecimal.valueOf(2200));
		CreateAccountRequest request = new CreateAccountRequest(account.getAccountNumber(), account.getAccountHolderName(), account.getEmail(), account.getCurrency(), account.getBalance());
		this.service.createAccount(request);
		assertThrows(ConflictException.class, () -> this.service.createAccount(request));
		this.service.removeAccountEntry(account.getAccountNumber()); // cleanup before other tests
	}
	
	
	@Test
	void updateCustomer() {
		AccountEntity account = new AccountEntity("ACC123", "testFirst", "testEmail@rmail.com", "CAD", BigDecimal.valueOf(2310));
		CreateAccountRequest request = new CreateAccountRequest(account.getAccountNumber(), account.getAccountHolderName(), account.getEmail(), account.getCurrency(), account.getBalance());
		//this.service.removeAccountEntry(account.getAccountNumber()); // cleanup before other tests
		AccountResponse result = this.service.createAccount(request);
		UpdateAccountRequest upRequest = new UpdateAccountRequest("testUpdate", "testEmail@rmail.com");
		account = new AccountEntity(account.getAccountNumber(), account.getAccountHolderName(), account.getEmail(), account.getCurrency(), account.getBalance()); 
		AccountResponse upResult = this.service.updateAccount("ACC123", upRequest);
		assertNotNull(upResult);
		assertEquals("testUpdate", upResult.accountHolderName());
		this.service.removeAccountEntry(account.getAccountNumber()); // cleanup before other tests
	}


	

}
