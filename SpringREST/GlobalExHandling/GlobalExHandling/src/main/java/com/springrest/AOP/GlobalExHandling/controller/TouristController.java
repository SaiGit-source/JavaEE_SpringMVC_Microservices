package com.springrest.AOP.GlobalExHandling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.AOP.GlobalExHandling.exception.TouristNotFoundException;
import com.springrest.AOP.GlobalExHandling.model.Tourist;
import com.springrest.AOP.GlobalExHandling.service.iTouristService;

// we got to remove ExceptionHandling from Controller
// Main purpose of Aspect Oriented Programming(AOP) is to separate main logic and secondary logic
// Globally i would like to handle exceptions of the application. When i send request to RestAPI, it calls the service method to process the request. if exception occurs, instead of exception going to RestController it goes into RestControllerAdvice. that's Aspect Oriented Programming (AOP)


@RestController
public class TouristController {
	
	@Autowired
	private iTouristService service;
	
	//http://localhost:8686/getalltourists
	//return all records
	@GetMapping("/getalltourists")
	public ResponseEntity<?> getAllTourists() {
		
		List<Tourist> tourists = service.fetchAllTourists();
		return new ResponseEntity<List>(tourists, HttpStatus.OK);
		
	}
//http://localhost:8686/gettouristbyid/10	
/*
 * {
    "statusCode": "404 not found",
    "exceptionMsg": "Custom Exception: Tourist ID not found in database",
    "dateTime": "2024-11-22T01:46:51.8869045"
}
 */
	@GetMapping("/gettouristbyid/{id}")
	public ResponseEntity<?> getTouristById(@PathVariable("id")Integer tid) throws TouristNotFoundException {
		Tourist tobj;
		tobj = service.fetchTouristById(tid);
		return new ResponseEntity<Tourist>(tobj, HttpStatus.OK);
	}
	
	// http://localhost:8686/registertourist
	// do it from postman tool
	@PostMapping("/registertourist")
	public ResponseEntity<?> registerTouristinDB(@RequestBody Tourist tourist) {
		String status = service.registerTourist(tourist);
		return new ResponseEntity<String>(status, HttpStatus.CREATED);
	}
	
	// to update majority of the record, we use @putMapping otherwise @patchMapping
	// http://localhost:8686/updatetourist
	// set put in postman
	
	@PutMapping("/updatetourist")
	public ResponseEntity<?> updateEntireRecord(@RequestBody Tourist tourist) throws TouristNotFoundException{
		String status;
		status = service.updateTouristInfo(tourist);
		return new ResponseEntity<String>(status, HttpStatus.OK);
	}
	
	// http://localhost:8686/updatetouristbudget/2/4342.36
	// set patch in postman
	@PatchMapping("/updatetouristbudget/{id}/{budget}")
	public ResponseEntity<?> updateTouristParam(@PathVariable("id") Integer tid, @PathVariable("budget") Double tbudget) throws TouristNotFoundException{
		String status;
			status = service.updateTouristBudget(tid, tbudget);
			return new ResponseEntity<String>(status, HttpStatus.OK);
	}
	
	// http://localhost:8686/deletetourist/2
	/*
	 * {
    "statusCode": "404 not found",
    "exceptionMsg": "Tourist ID 2 not found for record deletion",
    "dateTime": "2024-11-22T01:48:09.9406828"
}
	 */
	@DeleteMapping("/deletetourist/{id}")
	public ResponseEntity<?> deleteRecord(@PathVariable("id")Integer tid) throws TouristNotFoundException{
		String status;
			status = service.deleteTouristById(tid);
			return new ResponseEntity<String>(status, HttpStatus.OK);		
	}

}
