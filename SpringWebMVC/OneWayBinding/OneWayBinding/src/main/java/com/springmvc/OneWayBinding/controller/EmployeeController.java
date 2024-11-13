package com.springmvc.OneWayBinding.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springmvc.OneWayBinding.model.Employee;

// this is an example of one-way form binding
// Run As Java application
// http://localhost:8888/Formdata/register
// first it sends the applicationform.jsp when there is a get request then response.jsp when there is a post request to the same endpoint '/register'


@Controller
public class EmployeeController {
	
	@GetMapping("/register")
	public String getEmpInfo() {
		
		return "applicationform";
	}
	
	// when there is a post request to register page, Spring creates Employee object and injects here 
	@PostMapping("/register")
	public String register(Map<String, Object> map, Employee emp) {
		System.out.println(emp);
		map.put("empKey", emp);
		return "response";
	}

}
