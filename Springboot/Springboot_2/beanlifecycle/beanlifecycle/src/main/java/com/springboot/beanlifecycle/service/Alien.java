package com.springboot.beanlifecycle.service;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Service
public class Alien {
	static {
		System.out.println("Bean static block");
	}
	
	{
		System.out.println("Java initialization block");
	}

	public Alien() {
		super();
		System.out.println("Constructor: Bean created");
	}
	
	@PostConstruct
	public void init()
	{
		System.out.println("Init method of Alien");
	}

	
	public void disp() {
		System.out.println("Disp method - business logic");
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("Destroy bean");
	}

}
