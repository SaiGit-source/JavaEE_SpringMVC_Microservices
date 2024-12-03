package com.SpringRest.ActuatorExample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringRest.ActuatorExample.service.ActuatorService;

/*
 * Actuators has pre-defined endpoints, we can learn what's going on with the application during production. we can monitor the application using HTTP endpoints

management.endpoints.web.exposure.exclude=env, beans to avoid these things to be displayed for security reasons

shutdown is the only endpoint that's not binded to GET request, shutdown needs to be enabled manually

 */
// look into application.properties

// when i  run http://localhost:8284/actuator from Postman i get the following

/*
 * {
    "_links": {
        "self": {
            "href": "http://localhost:8284/actuator",
            "templated": false
        },
        "health": {
            "href": "http://localhost:8284/actuator/health",
            "templated": false
        },
  }
 */

// http://localhost:8284/actuator/health

/*
 * {
    "status": "UP"
}
 */

//http://localhost:8284/actuator/shutdown
// shutdown will shutdown the entire Actuator application


@RestController
public class ActuatorController {
	
	@Autowired
	private ActuatorService service;
	
	@GetMapping("/info")
	public ResponseEntity<?> getExample(){
		return new ResponseEntity<String>(service.getExample(), HttpStatus.OK);
	}

}
