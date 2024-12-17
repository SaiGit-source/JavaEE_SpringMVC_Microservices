package com.microservices.MainMicroservice.rest;

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
	
	@GetMapping("/get-main-info")
	public ResponseEntity<String> getCourseInfo()
	{
		String info="Welcome to the main page! I am the main microservice";
		return new ResponseEntity<String>(info,HttpStatus.OK);
	}

}
