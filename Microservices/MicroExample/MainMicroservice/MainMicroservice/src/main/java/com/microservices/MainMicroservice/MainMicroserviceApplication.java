package com.microservices.MainMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MainMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainMicroserviceApplication.class, args);
	}

}
