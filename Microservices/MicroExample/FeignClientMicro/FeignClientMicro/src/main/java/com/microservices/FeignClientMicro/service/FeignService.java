package com.microservices.FeignClientMicro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

//lets say the MainMicroservice is running on a different port now: 8581 instead of the usual 8481, FeignClient will still get the response, unlike RestTenplate/WebClient

@Service
public class FeignService {
	
	@Autowired
	private IFeignClient feignClient;
	
	public String getAccessAnotherAPI() {
		ResponseEntity<String> response = feignClient.getAnotherAPI();
		return "FeignClient: " + response.getBody()+ " coming from MainMicroservice";
	}

}
