package com.logging.LoggingGreetings.service;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logging.LoggingGreetings.controller.GreetingsController;



@Service
public class GreetingService implements iGreetingsService {
	
	private static final Logger logger = LoggerFactory.getLogger(GreetingsController.class);
	
	@Autowired
	private LocalDateTime time;
	// 2024-11-21T23:04:08.558-05:00 DEBUG 21296 --- [LoggingGreetings] [nio-8080-exec-1] c.l.L.controller.GreetingsController     : Within Generate Greeting service method
	
	@Override
	public String generateGreeting() {
		logger.debug("Within Generate Greeting service method");
		// LocalDateTime time = new LocalDateTime.now(); also works
		int hour = time.getHour();
		if (hour < 12) {
			return "Good morning";
		}
		else if (hour < 16) {
			return "Good afternoon";
		}
		else if (hour < 20) {
			return "Good evening";
		}
		else {
			return "Good night";
		}
		
	}
	

}
