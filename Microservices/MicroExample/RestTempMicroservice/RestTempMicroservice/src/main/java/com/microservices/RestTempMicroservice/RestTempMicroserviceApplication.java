package com.microservices.RestTempMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

// http://localhost:8585/getWelcomePage
// RestTemplateAPI: Welcome to the main page! I am the main microservice msg from MainMicroservice

@SpringBootApplication
@EnableDiscoveryClient
public class RestTempMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestTempMicroserviceApplication.class, args);
	}

}
