package com.springwebmvc.PathParamWebApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


// we pass the data in the form of path in the URL
//http://localhost:8888/PathParams/getinfo/Xyz/Springboot

// http://localhost:8888/PathParam/getInfo/Xyz/Springboot

@Controller
public class PathParamController {
	
	@GetMapping("/getInfo/{course}/{name}")
	public String getInfo(@PathVariable("name")String n, @PathVariable("course")String c, Model model) {
		
		String info = "Hello "+n+"This is PathParam example: "+c+" course";
		model.addAttribute("msg", info);
		return "home";
	}
}
