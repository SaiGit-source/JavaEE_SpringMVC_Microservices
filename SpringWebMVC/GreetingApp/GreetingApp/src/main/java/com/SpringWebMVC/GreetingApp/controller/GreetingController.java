package com.SpringWebMVC.GreetingApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.SpringWebMVC.GreetingApp.service.IGreetings;


@Controller
public class GreetingController 
{
	@Autowired
	private IGreetings GreetingService;
	
	@GetMapping("/greet")
	public String greetController(Model model) {
		String message = GreetingService.generateWish("Abc");
		model.addAttribute("wish", message);
		return "greeting";
	}

}
