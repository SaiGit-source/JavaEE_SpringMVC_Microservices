package com.springwebmvc.ModelwithObject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springwebmvc.ModelwithObject.model.Course;

// http://localhost:8888/CourseApp/coursemodel

// http://localhost:8888/CourseApp/courseobject

@Controller
public class courseController {
	
	@GetMapping("/coursemodel")
	public String getCourseInfo(Model model) {
		model.addAttribute("cid", "T23");
		model.addAttribute("cname", "Springboot");
		model.addAttribute("cprice", 3432.23);
		return "courseModel";
	}
	
	@GetMapping("/courseobject")
	public String getCourseObj(Model model) {
		Course course = new Course();
		course.setCid("123");
		course.setCname("Java");
		course.setCprice(2334.23);
		model.addAttribute("courseModelKey", course);
		return "courseObj";
	}
}
