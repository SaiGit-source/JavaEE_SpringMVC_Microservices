package com.springwebmvc.MultipleControllers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/education2")
public class SecondController {
	
	@GetMapping("/welcome")
	public String getSecondResponse(Model model) {
		model.addAttribute("secondKey", "Hello from Second Controller");
		return "second"; // this needs to match .jsp name
	}
}
