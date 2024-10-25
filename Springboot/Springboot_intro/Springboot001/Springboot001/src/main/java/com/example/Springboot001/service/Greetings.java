package com.example.Springboot001.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Greetings implements GreetingsInterface {
	
	
	public Greetings() {
		super();
		System.out.println("Greetings bean created");
	}
	
	@Autowired
	LocalDateTime time;
	
	@Override
	public String generateWish(String name) {
		
		if (time.getHour() < 12) {
			return "Good morning "+name;
		}
		if (time.getHour() < 16) {
			return "Good afternoon "+name;
		}
		if (time.getHour() < 20) {
			return "Good evening "+name;
		}
		else {
			return "Good night "+name;
		}
	}

}
