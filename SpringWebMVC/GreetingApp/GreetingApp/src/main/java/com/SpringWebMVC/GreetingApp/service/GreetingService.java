package com.SpringWebMVC.GreetingApp.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService implements IGreetings {
	
	@Autowired
	private LocalDateTime time;

	@Override
	public String generateWish(String name) {
		if (time.getHour()<12) {
			return "Good morning "+name;
		}
		else if (time.getHour()<16) {
			return "Good afternoon "+name;
		}
		else if (time.getHour()<20) {
			return "Good evening "+name;
		}
		else {
			return "Good night "+name;
		}
	}

}
