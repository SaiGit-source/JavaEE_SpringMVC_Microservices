package com.SpringRest.ExceptionHandlingApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringRest.ExceptionHandlingApp.exception.TouristNotFoundException;
import com.SpringRest.ExceptionHandlingApp.model.Tourist;
import com.SpringRest.ExceptionHandlingApp.service.iTouristService;

// in this app, we are implementing ExceptionHandling in Controller, which shouldn't be done actually

@RestController
public class TouristController {
	
	@Autowired
	private iTouristService service;
	
	//http://localhost:8686/getalltourists
	//return all records
	@GetMapping("/getalltourists")
	public ResponseEntity<?> getAllTourists() {
		try {
		List<Tourist> tourists = service.fetchAllTourists();
		return new ResponseEntity<List>(tourists, HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<String>("Exception: some problem in fetchAll", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//http://localhost:8686/gettouristbyid/5
	//there is no ID 5 in database
	//Custom Exception: Tourist ID not found in database
	@GetMapping("/gettouristbyid/{id}")
	public ResponseEntity<?> getTouristById(@PathVariable("id")Integer tid) {
		Tourist tobj;
		try {
			tobj = service.fetchTouristById(tid);
			return new ResponseEntity<Tourist>(tobj, HttpStatus.OK);
		} catch (TouristNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	// http://localhost:8686/registertourist
	// do it from postman tool
	@PostMapping("/registertourist")
	public ResponseEntity<?> registerTouristinDB(@RequestBody Tourist tourist) {
		try {
		String status = service.registerTourist(tourist);
		return new ResponseEntity<String>(status, HttpStatus.CREATED);
			}
		catch(Exception e) {
			return new ResponseEntity<String>("Exception: problem in register", HttpStatus.INTERNAL_SERVER_ERROR);	
			}
	}

}
