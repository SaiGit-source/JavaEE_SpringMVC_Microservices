package com.spring.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // @Component + configuration-related
public class Config {
	
	public Config()
	{
		System.out.println("Config  bean created");
	}
	
	@Bean // @Bean makes this object part of Spring framwork even though we are creating the object manually
	public Password createPasswordBean()
	{
		Password pass=new Password("SHA");
		return pass;
	}

	
}
