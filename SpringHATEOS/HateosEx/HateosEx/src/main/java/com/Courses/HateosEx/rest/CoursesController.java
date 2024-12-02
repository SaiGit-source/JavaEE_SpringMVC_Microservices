package com.Courses.HateosEx.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Courses.HateosEx.model.Courses;

// For Hateos, we need to extend RepresentationModel in model class
// it only provide a few options and when we click more it lists all options

// when you type the following in Postman
// localhost:8080/course-info
// Output in Postman
/*
 * {
    "cId": 1,
    "cName": "DevOps with AWS",
    "cCost": 9999.8,
    "_links": {
        "Get All Course": {
            "href": "http://localhost:8080/all-course-info"
        }
    }
}
 */

// i clock on "Get All Course" then i get all courses

/*
 * [
    {
        "cId": 1,
        "cName": "DevOps with AWS",
        "cCost": 9999.8,
        "links": []
    },
    {
        "cId": 2,
        "cName": "DevOps",
        "cCost": 999.8,
        "links": []
    },
    {
        "cId": 3,
        "cName": "AWS",
        "cCost": 9999.8,
        "links": []
    }
]
 */



@RestController
public class CoursesController {
	
	@GetMapping("/course-info")
	public ResponseEntity<Courses> getCourseInfo()
	{
		Courses course=new Courses(1,"DevOps with AWS", 9999.8);
		Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
				.methodOn(CoursesController.class).getAllCourseInfo()).withRel("Get All Course");
		
		
		course.add(link);
		return new ResponseEntity<Courses>(course, HttpStatus.OK);
	}
	
	@GetMapping("/all-course-info")
	public ResponseEntity<List> getAllCourseInfo()
	{
		Courses course1=new Courses(1,"DevOps with AWS", 9999.8);
		Courses course2=new Courses(2,"DevOps", 999.8);
		Courses course3=new Courses(3,"AWS", 9999.8);
		
		List<Courses>courses=new ArrayList<>();
		courses.add(course1);
		courses.add(course2);
		courses.add(course3);
		
		return new ResponseEntity<List>(courses, HttpStatus.OK);
	}



}
