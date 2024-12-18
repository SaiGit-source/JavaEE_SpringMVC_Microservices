package com.SpringBoot.CloudConfigServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

// Microservice is an independent application with its own yaml, properties and database
// any small change in properties file, we got to re-package and re-deploy. thats where we have Spring Cloud Config server. it will help separate yaml config files from actual application

@SpringBootApplication
@EnableConfigServer
public class CloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudConfigServerApplication.class, args);
	}

}
