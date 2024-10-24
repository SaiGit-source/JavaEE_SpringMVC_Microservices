package com.onlyannotation.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Greetings
{
	@Autowired
	private LocalDateTime time;
	
	public Greetings()
	{
		System.out.println("Greetings bean created");
	}
	
	public String generateGreeting(String name)
	{
		if (time.getHour() < 12) 		
		{
			return "Good Morning to you "+ name;
		}
			
		if (time.getHour() < 16) 		
		{
				return "Good Afternoon to you "+ name;
		}
		
		if (time.getHour() < 20) 		
		{
				return "Good Evening to you "+ name;
		}
		else 		
		{
				return "Good Night to you "+ name;
		}
		
	}
	

}