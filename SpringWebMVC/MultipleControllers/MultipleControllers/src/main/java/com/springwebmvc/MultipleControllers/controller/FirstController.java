package com.springwebmvc.MultipleControllers.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// instead of ModelandView we are using Model, which is better
//@GetMapping is better

@Controller
@RequestMapping("/education")
public class FirstController 
{
	@GetMapping("/welcome")
	public String displaySomeResponse(Model model) {
		model.addAttribute("homeKey", "You are in home from FirstController");
		return "home"; // note: this needs to match .jsp name like home.jsp
	}
	
	@GetMapping("/skill")
	public String displaySomeImportantMsg(Model model)
	{
		model.addAttribute("focusKey", "Focus is the most important skill");
		return "focus";
	}
	
	// with a different HTTP request it is ok to have the same path /skill
	@PostMapping("/skill")
	public String displaySomeImportantMsgPost(Model model)
	{
		model.addAttribute("focusKey", "Focus is the most important skill");
		return "focusKey";
	}
	
	// Map class also works here, it makes the application non-invasive. whenever we use third-party libraries/framework like Spring the application becomes invasive
	
	@GetMapping("/udemy")
	public String displaySomeImportantInfo(Map<String,Object> map)
	{
		System.out.println(map.getClass().getName());
		map.put("udemyKey", "Java Springboot with AWS course offered at discounted price");
		return "udemy";
	}
	

}
