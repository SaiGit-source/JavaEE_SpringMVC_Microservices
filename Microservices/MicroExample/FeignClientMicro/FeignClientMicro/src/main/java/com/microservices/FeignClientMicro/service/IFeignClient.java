package com.microservices.FeignClientMicro.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


// whichever microservice we are trying to connect, we write its name here
//lets say the MainMicroservice is running on a different port now: 8581 instead of usual 8481, FeignClient will still get the response, unlike RestTenplate/WebClient

@FeignClient(name="MAINMICROSERVICE")
public interface IFeignClient {
	
	@GetMapping("/get-main-info")
	public ResponseEntity<String> getAnotherAPI();

}
