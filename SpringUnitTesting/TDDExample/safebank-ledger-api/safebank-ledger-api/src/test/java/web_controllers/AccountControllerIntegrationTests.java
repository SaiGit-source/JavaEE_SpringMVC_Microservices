package web_controllers;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.MediaType;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safebank.ledgerapi.LedgerApiApplication;
import com.safebank.ledgerapi.account.dto.CreateAccountRequest;
import com.safebank.ledgerapi.account.dto.UpdateAccountRequest;
import com.safebank.ledgerapi.account.entity.AccountEntity;
import com.safebank.ledgerapi.account.repository.AccountRepository;
import com.safebank.ledgerapi.account.service.AccountService;

import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

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
    void getAccount() throws Exception {
    	this.mockMVC.perform(get("/api/accounts/SB-100001")).andExpect(status().isOk())
    	.andExpect(content().string(containsString("SB-100001")));
    }
    
    
    @Test
    void getAccount_NotFound() throws Exception {
    	this.mockMVC.perform(get("/api/accounts/SB-100010")).andExpect(status().isNotFound());
    }
    
    
    @Test
    void createAccount() throws Exception {
		CreateAccountRequest request = new CreateAccountRequest("SB-UNIQUE", "John Doe", "john@rmail.com", "CAD", BigDecimal.valueOf(2310));
		String jsonPayload = objectMapper.writeValueAsString(request);

	    this.mockMVC.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post("/api/accounts")
	        .contentType(MediaType.APPLICATION_JSON_VALUE) // Tells the controller JSON is coming
	        .content(jsonPayload))                                            // Drops the JSON string into the body
	        .andExpect(status().isCreated()) // Asserts HTTP 201 Created
	        .andExpect(MockMvcResultMatchers.jsonPath("$.accountNumber").value("SB-UNIQUE"))
	        .andExpect(MockMvcResultMatchers.jsonPath("$.accountHolderName").value("John Doe"));
    }
    
    
    
    @Test
    void createAccount_2() throws Exception {
		CreateAccountRequest request = new CreateAccountRequest("SB-10002", "John Doe", "john@rmail.com", "CAD", BigDecimal.valueOf(2310));
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(request);
        this.mockMVC.perform(post("/api/accounts")
        		.content(jsonString)
        		.contentType("application/json"))
        		.andExpect(status().isCreated())
        		.andExpect(content().string(containsString("john@rmail.com")));
    }

    
    
    @Test
    void createAccount_exists() throws Exception {
		CreateAccountRequest request = new CreateAccountRequest("SB-100001", "John Doe", "john@rmail.com", "CAD", BigDecimal.valueOf(2310));
		String jsonPayload = objectMapper.writeValueAsString(request);

	    this.mockMVC.perform(post("/api/accounts")
	        .contentType("application/json") // Tells the controller JSON is coming
	        .content(jsonPayload))
	    	.andExpect(status().isConflict());
    }
    
    
    
    @Test
    void updateAccount_Success() throws Exception {
      UpdateAccountRequest upRequest = new UpdateAccountRequest("testUpdate", "testEmail@rmail.com");
      ObjectMapper mapper = new ObjectMapper();
      String jsonString = mapper.writeValueAsString(upRequest);
      this.mockMVC.perform(put("/api/accounts/SB-100001")
    		  	.content(jsonString).contentType("application/json"))
      			.andExpect(status().isOk())
          		.andExpect(content().string(containsString("testUpdate")))
          		.andExpect(content().string(containsString("USD")));
    }


    
    @Test
    void closeAccount_Success() throws Exception {
		CreateAccountRequest request = new CreateAccountRequest("SB-10002", "John Doe", "john@rmail.com", "CAD", BigDecimal.ZERO);
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(request);
        this.mockMVC.perform(post("/api/accounts")
        		.content(jsonString)
        		.contentType("application/json"));
      
        this.mockMVC.perform(delete("/api/accounts/SB-10002")).andExpect(status().isNoContent());
    }
    
    
    
    @Test
    void testGetRequestAttribute_Success() throws Exception {
        // 1. Execute the request and grab the MvcResult handle
        MvcResult mvcResult = this.mockMVC.perform(get("/api/accounts/profile")
                // Simulating an attribute set by a pre-handle interceptor or security filter
                .requestAttr("userEmail", "admin@safebank.com")) 
            .andExpect(status().isOk())
            .andReturn(); // <-- Extracts the full execution wrapper

        // 2. Use getRequest().getAttribute() exactly like you wanted
        Object attributeValue = mvcResult.getRequest().getAttribute("userEmail");

        // 3. Run standard JUnit assertions on the extracted attribute
        assertNotNull(attributeValue);
        assertEquals("admin@safebank.com", attributeValue.toString());
    }
    
    
    
    @Test
    void testResponseEntityWithAttribute() throws Exception {
        // 1. Seed the attribute and execute the request
        MvcResult mvcResult = this.mockMVC.perform(get("/api/accounts/profile1")
                .requestAttr("userEmail", "test.user@safebank.com"))
            .andExpect(status().isOk()) // Validates the ResponseEntity 200 OK status
            .andExpect(content().string(containsString("test.user@safebank.com"))) // Validates body text
            .andReturn();

        // 2. Extract and assert the internal request attribute container directly
        Object actualAttribute = mvcResult.getRequest().getAttribute("userEmail");
        
        assertNotNull(actualAttribute);
        assertEquals("test.user@safebank.com", actualAttribute.toString());
    }
    
}
