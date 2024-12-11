package com.SpringSecurity.SessionExample.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringSecurity.SessionExample.model.Users;
import com.SpringSecurity.SessionExample.service.UserService;

@RestController
public class UserController {
	
	// we got to encrypt the new user password using BCrypt algorithm and save in Database
	
	@Autowired
	private UserService service;
	
	BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder(12);
	// 12 rounds of encoding
	// http://localhost:8080/add-newuser // all users are permitted to access this API because it's like Signup
	// {"name":"Abc","password":"$2a$12$i9cBUqvccXedz8hN6dcLZ.lhc7UYdy4UctqRR20X3jogDZX6zYJie"}
	@PostMapping("/add-newuser")
	public Users registerUser(@RequestBody Users user) {
		String encoded = bcrypt.encode(user.getPassword());
		user.setPassword(encoded);
		return service.saveNewUser(user);
	}
	
	@GetMapping("/get-welcome")
	public String getWelcome() {
		return "Welcome to the page, you have successfuly logged in";
	}
	
}
