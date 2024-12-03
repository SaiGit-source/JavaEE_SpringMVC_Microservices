package com.SpringRest.MokitoTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringRest.MokitoTest.model.Student;
import com.SpringRest.MokitoTest.service.IGeneralService;

// Why Mokito? we want to achive isolation while unit testing. for example, i wrote this Controller method "getGreeting" but not this service method "service.generateGreeting(name)".
// so if my test case fails because of this service method i am not responsible, so i mock the result of this method in my unit test
// right-click GeneralControllerTest.java and Run-As "JUnit Test"

@RestController
public class GeneralController {
	
	@Autowired
	private IGeneralService service;
	
	@GetMapping("/greet")
	public ResponseEntity<String> getGreeting(String name) {
		String greet = service.generateGreeting(name);
		return new ResponseEntity<String>(greet, HttpStatus.OK);
	}
	
	@PostMapping("/addStudent")
	public ResponseEntity<String> addStu(@RequestBody Student student) {
		Boolean status=service.addStudent(student);
		if(status) {
			String msg = "Student is added";
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}
		else {
			String msg = "Student is not added";
			return new ResponseEntity<String>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
