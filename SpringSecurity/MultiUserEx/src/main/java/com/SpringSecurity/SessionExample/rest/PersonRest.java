package com.SpringSecurity.SessionExample.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringSecurity.SessionExample.model.Person;

import jakarta.servlet.http.HttpServletRequest;


// in this example, we are disrupting the SpringSecurity default behavior by making application Stateless, disabling CSRF then adding multi-user authentication

// http://localhost:8080/get-person
// Postman -> Authentication -> Basic Auth -> enter user and password

// the other issue is we have a common login credential for all resources and all users. but we want different credentials and different access to different users

@RestController
public class PersonRest {
	
	List<Person> personList = new ArrayList<>(List.of(new Person(1, "Abc", "Brooklyn"), new Person(2, "Pqr", "Charlotte"), new Person(3, "Xyz", "Lincoln"))); 
	
	@GetMapping("/get-person")
	public List<Person> getPerson(){
		
		return personList;
	}
	
	@PostMapping("/add-person")
	public void addPerson(@RequestBody Person person) {
		personList.add(person);
		System.out.println(person);
	}
	
	// it gives the session ID: XXXXXXXXXXXXXXXXXXXXXX32791
	@GetMapping("/get-sessionid")
	public String getSessionID(HttpServletRequest request) {
		return ""+request.getSession().getId();
	}
	
	// now i send another request: it uses the same session: XXXXXXXXXXXXXXXXXXX32791
	@GetMapping("get-info")
	public String getSessionID2(HttpServletRequest request) {
		return "it uses the same session: "+request.getSession().getId();
	}

}
