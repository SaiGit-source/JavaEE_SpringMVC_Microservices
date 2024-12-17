package com.microservices.FeignClientMicro.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.FeignClientMicro.service.FeignService;

/*
 * http://localhost:8686/getWelcomePage
 * FeignClient: Welcome to the main page! I am the main microservice coming from MainMicroservice
 */

// whenever a microservice is trying to talk to another microservice, we use FeignClient because it doesn't hardcode the IP:Port of the microservice unlike RestTemplate
// it is best suited for load balancing, using round robin Load balancer can redistribute the load to other instances of the same microservice, running on different ports

// lets say the MainMicroservice is running on a different port now: 8581 instead of usual 8481, FeignClient will still get the response, unlike RestTenplate/WebClient

// to run FeignClientMicroservice on multiple servers
// Right-click Application.java -> Run-as -> Run Configurations -> Arguments -> VM arguments -> -Dserver.port=8086
// if you go to AdminServer you will see two instances of FeignClients

@RestController
public class FeignController {
	
	@Autowired
	private FeignService service;
	
	@GetMapping("/getWelcomePage")
	public ResponseEntity<?> getMainPage(){
		String msg = service.getAccessAnotherAPI();
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	


}
