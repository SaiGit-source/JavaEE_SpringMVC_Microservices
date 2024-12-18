package com.microservices.MainMicroservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * spring.boot.admin.client.url=http://localhost:1414/ to register with AdminServer

management.endpoints.web.exposure.include=* to enable Actuators

 */

/*
 * // to run MainMicroservice on multiple servers
// Right-click Application.java -> Run-as -> Run Configurations -> Arguments -> VM arguments -> -Dserver.port=8181
// if you go to AdminServer you will see two instances of MainMicroservice

 */

@RestController
public class MicroserviceController {
	
	@Autowired
	private Environment env;
	
	// the idea here is, load balancer sends requests to different instances or ports of the same application on round-robin basis
	
	@GetMapping("/get-main-info")
	public ResponseEntity<String> getCourseInfo()
	{
		String port = env.getProperty("server.port"); 
		String info="Welcome to the main page! I am the Main microservice from port: "+port;
		return new ResponseEntity<String>(info,HttpStatus.OK);
	}

}
