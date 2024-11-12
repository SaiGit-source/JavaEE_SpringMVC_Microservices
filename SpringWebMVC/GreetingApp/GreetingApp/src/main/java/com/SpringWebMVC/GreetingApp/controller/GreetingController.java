package com.SpringWebMVC.GreetingApp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.SpringWebMVC.GreetingApp.service.IGreetings;

import jakarta.servlet.http.HttpServletResponse;

//http://localhost:8484/GreetingApp/wish
//http://localhost:8484/GreetingApp/greet

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
	
	@GetMapping("/wish")
	public void generateWish2(HttpServletResponse response) throws IOException
	{
		String greeting=GreetingService.generateWish("Writer");
		PrintWriter writer = response.getWriter();
		writer.println("<h1>Hello this response is from controller directly"+greeting+"</h1>");
	
	}

}
