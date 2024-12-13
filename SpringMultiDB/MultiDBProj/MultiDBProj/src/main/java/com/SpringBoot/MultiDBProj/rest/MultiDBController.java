package com.SpringBoot.MultiDBProj.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.SpringBoot.MultiDBProj.service.MultiDbService;

// this shows how to connect and handle multiple DBs from the same SpringBoot application
// DB1: MySQL and DB2: Postgres

@RestController
public class MultiDBController {
	
	@Autowired
	private MultiDbService service;
	
	@GetMapping("/getCx")
	public ResponseEntity<?> getCustomers(){
		return new ResponseEntity<List>(service.getCustomer(), HttpStatus.OK);
	}
	
	@GetMapping("/getPd")
	public ResponseEntity<?> getProducts(){
		return new ResponseEntity<List>(service.getProduct(), HttpStatus.OK);
	}

}
