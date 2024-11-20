package com.SpringRest.JavaObject.restController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringRest.JavaObject.model.Person;

// Run as Java application
// Dispatcher servlet(JacksonAPI) converts JSON object into Java object and vice-versa
// output 
/* {
  "pid": 2,
  "pname": "Xyz",
  "pcity": "Lincoln"
}
*/

@RestController
@RequestMapping("/api2")
public class PersonController {
	
	@GetMapping("/resEntityOb")
	public ResponseEntity<Person> getPersonInfo1(){
		Person per = new Person(1, "Abc", "Corpus_Christi");
		return new ResponseEntity<Person>(per, HttpStatus.OK);
	}
	// http://localhost:8080/api2/personOb
	// output {"pid":2,"pname":"Xyz","pcity":"Lincoln"}
	@GetMapping("/personOb")
	public Person getPersonInfo2(){
		Person per = new Person(2, "Xyz", "Lincoln");
		return per;
	}

	// http://localhost:8080/api2/addPerson 
	// input
	/*
	 * {
		"pid": 3, 
		"pname": "Pqr", 
		"pcity": "Boise"
		}
	 */
	// pass this info into postman. enter data in body
	// output: converted into Person object: Person [pid=3, pname=Pqr, pcity=Boise]
	
	@PostMapping("/addPerson") // for post request we need postman tool
	public String addPersonInfo1(@RequestBody Person per){
		System.out.println(per);
		return "Data received";
	}



}
