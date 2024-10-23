package com.spring.service;

import org.springframework.stereotype.Component;

@Component // nothing special about this class so @Component
// tell Spring framework to create a bean of a particular class
public class Utility {

	public Utility() 
	{
		super();
		System.out.println("Utility bean created");

	}
	
	

}
