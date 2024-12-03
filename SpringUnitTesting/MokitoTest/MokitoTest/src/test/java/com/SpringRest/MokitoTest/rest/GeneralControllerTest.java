package com.SpringRest.MokitoTest.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.SpringRest.MokitoTest.controller.GeneralController;
import com.SpringRest.MokitoTest.model.Student;
import com.SpringRest.MokitoTest.service.IGeneralService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(GeneralController.class)
public class GeneralControllerTest {
	
	@MockBean // remember it cannot be @Autowired because we are creating a Mock object not real object/bean
	private IGeneralService service;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	//@Disabled // this test mocks a String input
	void testGetGreeting() throws Exception {
		// Mocking
		Mockito.when(service.generateGreeting("Abc")).thenReturn("Good morning");
		
		// RequestObject
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/greet");
		ResultActions result = mockMvc.perform(requestBuilder); // we perform the Get request here
		MvcResult mvcResult = result.andReturn();
		MockHttpServletResponse response =  mvcResult.getResponse();
		int statusCode = response.getStatus();
		
		// Assertion
		assertEquals(200, statusCode);
	}
	
	 // this test mocks a RequestBody / Student object. 
	// we replicate the real scenario with JSON input in Rest APIs
	@Test
	void testAddStudent() throws Exception {
		
		// Mocking
		Mockito.when(service.addStudent(ArgumentMatchers.any())).thenReturn(true);
		
		// input gets converted to JSON and Java objects and vice-versa
		// so we convert Java into JSON object to replicate the real input to RestController
		Student st = new Student(1, "Abc", "Madison");
		ObjectMapper mapper = new ObjectMapper();
		String jsonInput = mapper.writeValueAsString(st);
		
		// RequestBuilder
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addStudent")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonInput); // we are passing JSON input, the function content() requires String object anyways
		ResultActions result = mockMvc.perform(requestBuilder);
		MvcResult mvcResult=result.andReturn();
		MockHttpServletResponse resp = mvcResult.getResponse();
		int statusCode = resp.getStatus();
		
		// Assertion
		assertEquals(200, statusCode);
	}

}
