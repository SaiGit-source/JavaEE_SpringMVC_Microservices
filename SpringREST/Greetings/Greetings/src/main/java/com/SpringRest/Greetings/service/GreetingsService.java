package com.SpringRest.Greetings.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingsService implements iGreetingsService {

	@Autowired
	private LocalDateTime time;
	
	@Override
	public String generateWish(String name) {
		// LocalDateTime time = LocalDateTime.now();// this also works but we are adding config class 
		
		int hour = time.getHour();
		if (hour < 12) {
			return "Good morning "+name;
		}
		else if (hour < 16) {
			return "Good afternoon "+name;
		}
		else if (hour < 20) {
			return "Good evening "+name;
		}
		else {
			return "Good night "+name;
		}
		
	}

}
