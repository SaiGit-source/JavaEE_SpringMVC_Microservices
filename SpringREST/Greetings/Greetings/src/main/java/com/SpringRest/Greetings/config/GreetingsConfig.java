package com.SpringRest.Greetings.config;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreetingsConfig {

	@Bean
	public LocalDateTime genTime() {
		return LocalDateTime.now();
	}

}
