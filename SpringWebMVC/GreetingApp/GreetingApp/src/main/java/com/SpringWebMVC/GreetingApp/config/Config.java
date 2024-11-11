package com.SpringWebMVC.GreetingApp.config;



import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config 
{
	@Bean
	public LocalDateTime getTimeBean() {
		return LocalDateTime.now();
	}

}
