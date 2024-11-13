package com.springmvc.JSTLExample.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// JSTL demo for processing Arrays and Collections

// http://localhost:8888/ArraysCollections/home
/*
 * Displaying Data From an Array/Collection
	Java, Springboot, Hibernate,
 */


@Controller
public class BooksController {
	
	@GetMapping("/home")
	public String getHomePage() {
		
		return "home";
	}
	
	@GetMapping("/response")
	public String getBooksInfo(Map<String, Object> map) {
		String[] books = new String[] {"Java", "Springboot", "Hibernate"};
		Arrays.asList(books).forEach(b->System.out.println(b));
		
		map.put("booksKey", books);
		return "response"; // redirects to response.jsp page
	}

}
