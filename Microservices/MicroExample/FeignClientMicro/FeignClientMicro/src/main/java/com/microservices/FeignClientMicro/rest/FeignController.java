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

/* Zipkin server
 * download from https://zipkin.io/pages/quickstart not part of Spring
 * it will help you know the performance of application. how much time one microservice is taking etc can be managed using Zipkin server. helps with visibility and to optimize performance of microservices
 * to start:
 *  C:\PATH_TO\openjdk-22.0.2_windows-x64_bin\jdk-22.0.2\bin\java.exe -jar zipkin-server-3.4.3-exec.jar
 *  runs on: http://127.0.0.1:9411/
 */

/* After API Gateway
 * 
 * // now instead of reaching out directly to FeignClientMicro: 
 * "http://localhost:8086/getWelcomePage", 
 * we reach out to API Gateway IP: http://localhost:8448/getWelcomePage
 * FeignClient: Welcome to the main page! I am the Main microservice from port: 8582 coming from MainMicroservice
 */

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
