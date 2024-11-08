package com.springwebmvc.FirstController.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FirstController {
	
	@RequestMapping("/welcome") // the app opens in http://localhost:8484/welcome
	public ModelAndView dispSomeResources()
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "Hello! Welcome to our first Spring Web MVC app");
		mav.setViewName("index");
		return mav;
	}

}
