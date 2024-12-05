package com.SpringAOP.AOPExample.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringAOP.AOPExample.model.Person;
import com.SpringAOP.AOPExample.service.IPersonService;

// http://localhost:8787/add-person
// http://localhost:8787/get-person-list


/*
 * Aspect Oriented Programming AOP:
Every application has business logic, main logic, purpose of App -> Actual function. for example, University website's main purpose is to provide Program info etc. 
Every application will have cross-cutting logic or secondary logic to support business logic, for example: Logging, Security, Exception handling
AOP is there to separate business logic and cross-cutting logic
 */

/*
 * 1. Aspect means Cross-cutting logic: such a logic, which contains the secondary logic like Security, Logging, Exception Handling. Aspect is talking about secondary logic
2. Advice: At what moment or when Aspect logic should execute: Advice decides when Aspect logic should get executed. RestControllerAdvice for example. BeforeAdvice -> Aspect logic is executed before executing the business logic, AfterAdvice > Aspect logic is executed after executing the business logic, AroundAdvice -> executes before , ThrowsAdvice -> executes AL while BL
3. Target: Target is a class that contains the actual business logic (main functionality). what you had in mind before developing application. 
4. JoinPoint: what's that exact point where secondary logic should integrate with BL. exact point where AL and BL should be integrated. for example, if there is an exception, thats where Advice will execute the Aspect Logic. so thats where BL and AL meet
5. Pointcut: which primary logic / business logic methods, to which secondary logic/AL should be applied to. AL by default will be applied to all methods in Target(BL). @pointcut we can specify where to apply bl1() not everywhere
6. Weaving: it is a process of combining target and aspect. Weaving will generate a Proxy class when combining target and aspect. this Proxy class will be executed at runtime by SpringAOP. Process of integration is called as Weaving
 */

// Setting 1: Aspect output
/*
 * Before Controller: Request made to ResponseEntity com.SpringAOP.AOPExample.rest.PersonController.getAllPerson() at 01:04:11.468869700
	Before Service: Request made to List com.SpringAOP.AOPExample.service.PersonService.getAllPersonInfo() at 01:04:11.470865200
 */
/*
 * After Service: Request made to List com.SpringAOP.AOPExample.service.PersonService.getAllPersonInfo() at 01:04:11.885012100
	After Controller: Request made to ResponseEntity com.SpringAOP.AOPExample.rest.PersonController.getAllPerson() at 01:04:11.895410900
 */

@RestController
public class PersonController {
	
	@Autowired
	private IPersonService service;
	
	@PostMapping("/add-person")
	public ResponseEntity<?> savePersonRecord(@RequestBody Person person){
		// the body or payload is coming from Postman, Swagger or UI thats why we say RequestBody
		Person p = service.registerPerson(person);
		return new ResponseEntity<Person>(p, HttpStatus.OK);
	}
	
	@GetMapping("/get-person-list")
	public ResponseEntity<?> getAllPerson(){
		List<Person> pLst = service.getAllPersonInfo();
		return new ResponseEntity<List>(pLst, HttpStatus.OK);
	}

}
