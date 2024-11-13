package com.springwebmvc.QueryParamWebApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// http://localhost:8888/QueryParam/getinfo?name=Abc&course=Java

// we are passing data through URL

@Controller
public class QueryController {
	
	@GetMapping("/getinfo")
	public String getSomeInfo(@RequestParam("name")String n,@RequestParam("course")String c,
			Model model)
	{
		String info="Hello "+ n+" hope this "+c+" course is good";
		model.addAttribute("msg", info);
		return "home";
	}

}
