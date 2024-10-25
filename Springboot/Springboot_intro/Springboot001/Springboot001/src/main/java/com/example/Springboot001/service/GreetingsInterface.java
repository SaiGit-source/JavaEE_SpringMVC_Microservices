package com.example.Springboot001.service;

import org.springframework.stereotype.Service;

@Service
public interface GreetingsInterface 
{
	public String generateWish(String name);

}
