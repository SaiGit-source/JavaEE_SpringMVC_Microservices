package com.SpringRest.Greetings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.SpringRest.Greetings.service.iGreetingsService;

// @Controller + @ResponseBody = @RestController
// http://localhost:8080/api1/greet2

// both greet1 and greet2 APIs display the same output "Good night Abc"


@Controller
@RequestMapping("/api1")
public class GreetingsController {
	
	@Autowired
	private iGreetingsService service;
	
	@GetMapping("/greet1")
	@ResponseBody
	public ResponseEntity<String> getWish1() {
		String wish = service.generateWish("Abc");
		return new ResponseEntity<String>(wish, HttpStatus.OK);
	}
	
	@GetMapping("/greet2")
	@ResponseBody
	public String getWish2() {
		String wish = service.generateWish("Abc");
		return wish;
	}

}
