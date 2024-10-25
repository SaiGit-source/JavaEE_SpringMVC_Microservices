package com.example.Springboot001.config;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	public Config() {
		super();
		System.out.println("Configuration bean created");
	}
	
	@Bean // so now it is part of Spring framework
	public LocalDateTime createTime() {
		return LocalDateTime.now();
	}
	

}
