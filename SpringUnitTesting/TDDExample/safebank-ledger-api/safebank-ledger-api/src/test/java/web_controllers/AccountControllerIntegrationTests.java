package web_controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.MediaType;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.safebank.ledgerapi.LedgerApiApplication;
import com.safebank.ledgerapi.account.dto.AccountResponse;
import com.safebank.ledgerapi.account.dto.CreateAccountRequest;
import com.safebank.ledgerapi.account.entity.AccountEntity;
import com.safebank.ledgerapi.account.repository.AccountRepository;
import com.safebank.ledgerapi.account.service.AccountService;

@SpringBootTest(
    classes = LedgerApiApplication.class,
    properties = {
        "spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;MODE=MySQL;DATABASE_TO_LOWER=TRUE;CASE_INSENSITIVE_IDENTIFIERS=TRUE",
        "spring.datasource.driver-class-name=org.h2.Driver",
        "spring.jpa.hibernate.ddl-auto=update",
        "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect",
        "spring.sql.init.mode=never"
    }
)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = Replace.ANY)
public class AccountControllerIntegrationTests {

    @Autowired
    private MockMvc mockMVC;

    @Autowired
    private AccountRepository repository;
    
    @Autowired
    private com.fasterxml.jackson.databind.ObjectMapper objectMapper;
    
    @Autowired
    private AccountService service;
    
    @BeforeEach
    void setUp() {
        repository.deleteAllInBatch(); // This will work now because the table is created automatically
        repository.flush();

        // Use the custom argument constructor matching your Entity definitions
        AccountEntity testAccount = new AccountEntity(
            "SB-100001",
            "Chris Miller",
            "chris@safebank.com",
            "USD",
            new java.math.BigDecimal("1000.00")
        );

        repository.saveAndFlush(testAccount);
    }

    @Test
    void getAllAccounts() throws Exception {
        this.mockMVC.perform(get("/api/accounts"))
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("Chris Miller")))
            .andExpect(content().string(containsString("SB-100001")));
    }
    
    @Test
    void createAccount() throws Exception {
		CreateAccountRequest request = new CreateAccountRequest("SB-UNIQUE", "John Doe", "john@rmail.com", "CAD", BigDecimal.valueOf(2310));
		String jsonPayload = objectMapper.writeValueAsString(request);

	    this.mockMVC.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post("/api/accounts")
	        .contentType(MediaType.APPLICATION_JSON_VALUE) // Tells the controller JSON is coming
	        .content(jsonPayload))                                            // Drops the JSON string into the body
	        .andExpect(org.springframework.test.web.servlet.result.MockMvcResultMatchers.status().isCreated()) // Asserts HTTP 201 Created
	        .andExpect(org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath("$.accountNumber").value("SB-UNIQUE"))
	        .andExpect(org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath("$.accountHolderName").value("John Doe"));
    }
    
    
}
