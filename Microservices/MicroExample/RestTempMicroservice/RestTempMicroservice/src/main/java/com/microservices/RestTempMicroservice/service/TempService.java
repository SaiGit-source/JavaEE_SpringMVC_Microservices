package com.microservices.RestTempMicroservice.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TempService {
	// the problem with RestTemplate or WebClient is that, IP:Port is hardcoded so load balancing or distribution is not possible thats why we need FeignClient
	public String getAnotherAPI() {
		RestTemplate restTemp = new RestTemplate();
		ResponseEntity<String> response = restTemp.getForEntity("http://localhost:8481/get-main-info", String.class);
		return "RestTemplateAPI: " + response.getBody()+ " msg from MainMicroservice";
	}

}
