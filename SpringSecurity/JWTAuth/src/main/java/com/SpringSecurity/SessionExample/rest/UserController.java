package com.SpringSecurity.SessionExample.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringSecurity.SessionExample.model.Users;
import com.SpringSecurity.SessionExample.service.JwtTokenService;
import com.SpringSecurity.SessionExample.service.UserService;

@RestController
public class UserController {
	
	// JWT: JSON Web Token:
	// if the user is trustworthy, application generates the token for the user, next time the user visits, they dont need to provide login credentials again 
	// instead they got to present the JWTtoken to use to access application resources.
	
	// we got to encrypt the new user password using BCrypt algorithm and save in Database
	
	@Autowired
	private UserService service;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private JwtTokenService jwtService;
	
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
	
	// first POST add-newuser
	//http://localhost:8080/add-newuser
	/* 
	 * body: {
    "name": "jwtuser",
    "password": "$2a$12$zX5MTnvbZX.3H1je69AJaOj4t1IMag.w53Ju0JYnDmqANenUkbJcm"
}
	 */
	
	// second: POST http://localhost:8080/jwtlogin 
	// 
	/* body: {
    "name":"jwtuser",
    "password":"test"
	}
	*/
	// use the same user that was added using previous API
	// it generates JWT: eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqd3R1c2VyIiwiaWF0IjoxNzMzOTc5NzM4LCJleHAiOjE3MzQxNTk3Mzh9.aD8wr_MVSCWrWwHkbjzgu9kdSRVBu0YbTV8u9mAtL6E
	
	// third: GET http://localhost:8080/welcomePage
	// enter JWT into Bearer Token
	// Output: Welcome to the page, you have successfully logged in using JWT

	// fourth: GET http://localhost:8080/get-person
	// Also works with BOTH 'Bearer Token' and 'Basic Auth'
	
	
	// for JWT auth
	// generated token and returns to user for future accesses
	@PostMapping("/jwtlogin")
	public String loginUser(@RequestBody Users user) {
		System.out.println(user);
		Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getName(),user.getPassword()));
		
		if(authentication.isAuthenticated())
		{
			String jwt= jwtService.generateToken(user.getName());
			System.out.println("jwtlogin API: user: "+jwt);
			return jwt;
		}
		else
			return "Invalid credentials";
		
	}
	
	
	// when we call this API, user is authenticated using validateToken. User needs to pass in the token through Bearer Token header
	// third: GET http://localhost:8080/welcomePage
	// enter JWT into Bearer Token
	// Output: Welcome to the page, you have successfully logged in using JWT
	@GetMapping("/welcomePage")
	public String getWelcome() {
		return "Welcome to the page, you have successfully logged in using JWT";
	}
	
}
