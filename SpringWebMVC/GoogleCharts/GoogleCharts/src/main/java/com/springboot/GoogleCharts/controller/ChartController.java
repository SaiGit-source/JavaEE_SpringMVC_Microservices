package com.springboot.GoogleCharts.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// this is an example where i am passing data from Contoller into Thymeleaf html page then retrieving inside HTML and displaying Google Chart
@Controller
@RequestMapping("/")
public class ChartController {
	
	@GetMapping("/Homepage")
	public String Charts(Model model) {
		
        List<List<Object>> listData = Arrays.asList(Arrays.asList("Mushrooms", 3),Arrays.asList("Onions", 1),Arrays.asList("Olives", 1),Arrays.asList("Zucchini", 1),Arrays.asList("Pepperoni", 2));
		model.addAttribute("dataKey", listData);
		return "Homepage";
	}

}
