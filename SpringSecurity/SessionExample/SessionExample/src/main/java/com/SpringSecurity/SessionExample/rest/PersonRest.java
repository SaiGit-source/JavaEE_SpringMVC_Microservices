package com.SpringSecurity.SessionExample.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringSecurity.SessionExample.model.Person;

import jakarta.servlet.http.HttpServletRequest;


// Spring Security is all about authentication and authorization. who can access which resource for how much time.

/* 
Spring Security dependency creates a Login page by default
whenever you visit any application, based on first request, in the server, one session ID is generated automatically. Same user from the same client can access any of the resources as long as session ID is valid. when Session ID expires, the login page shows up again. once you login successfully you get the Session ID
disadvantage of session ID is that anyone can use that session ID and gain access to APIs and resources
thats why we have JWT, CSRF tokens and OAuth2
*/

// http://localhost:8080/get-person
// Postman -> Authentication -> Basic Auth -> enter user and password

// the other issue is we have a common login credential for all resources and all users. but we want different credentials and different access to different users

@RestController
public class PersonRest {
	
	List<Person> personList = new ArrayList<>(List.of(new Person(1, "Abc", "Brooklyn"), new Person(2, "Pqr", "Charlotte"), new Person(3, "Xyz", "Jacksonville"))); 
	
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
