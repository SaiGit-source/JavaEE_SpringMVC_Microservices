package com.MongoDB.Joblisting.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MongoDB.Joblisting.model.JobPost;
import com.MongoDB.Joblisting.repo.IPostRepo;
import com.MongoDB.Joblisting.service.IPostingService;

import springfox.documentation.annotations.ApiIgnore;


@RestController
public class JobPostController 
{	
	@Autowired
	private IPostingService service;
	// this is only for Swagger. it will redirect to swagger ui
	// it redirects to http://localhost:8080/swagger-ui.html
	@ApiIgnore
	@RequestMapping(value="/")
	public void redirect(HttpServletResponse response) throws IOException {
		response.sendRedirect("/swagger-ui.html");
	}
	
	// we are fetching all records from mongoDB
	@GetMapping("/allposts")
	public ResponseEntity<?> getAllPosts(){
		System.out.println(service.fetchAllRecords());
		return new ResponseEntity<List<JobPost>>(service.fetchAllRecords(), HttpStatus.OK);
	}
	
	@GetMapping("/allposts/{searchText}")
	public ResponseEntity<?> searchDB(@PathVariable("searchText") String searchText){
		List<JobPost> allRecords = service.fetchByKeyword(searchText);
		return new ResponseEntity<List<JobPost>>(allRecords, HttpStatus.OK);
	}
	
	@PostMapping("/jobpost")
	public ResponseEntity<?> addNewJobPost(@RequestBody JobPost jobpost){
	
		JobPost jp = service.addNewPosting(jobpost);
		return new ResponseEntity<JobPost>(jp, HttpStatus.OK);
	}
	
	

	
	
	
}
