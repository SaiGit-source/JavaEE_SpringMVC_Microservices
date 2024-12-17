package com.microservices.RestTempMicroservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.RestTempMicroservice.service.TempService;

// the problem with RestTemplate or WebClient is that, IP:Port is hardcoded so load balancing or distribution is not possible thats why we need FeignClient
// http://localhost:8585/getWelcomePage from Postman
// Welcome to the main page! I am the main microservice msg from MainMicroservice



@RestController
public class TemplateController {
	
	@Autowired
	private TempService service;
	
	@GetMapping("/getWelcomePage")
	public ResponseEntity<?> getMainPage()
	{
		String info = service.getAnotherAPI();
		return new ResponseEntity<String>(info, HttpStatus.OK);
	}

}
