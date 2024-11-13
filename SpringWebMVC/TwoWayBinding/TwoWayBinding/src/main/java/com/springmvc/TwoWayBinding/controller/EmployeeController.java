package com.springmvc.TwoWayBinding.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springmvc.TwoWayBinding.model.Employee;

// SpringTag is used for two-way binding, also @ModelAttribute("emp") 

@Controller
public class EmployeeController {
	
	@GetMapping("/register")
	public String getHome(@ModelAttribute("emp")Employee emp) {
		return "homePage";
	}
	
	// Map or Model both work
	@PostMapping("/register")
	public String registerForm(Map<String, Object>map, @ModelAttribute("emp")Employee emp) {
		
		System.out.println(emp);
		map.put("empKey", emp);
		return "responsePage";
	}

}
