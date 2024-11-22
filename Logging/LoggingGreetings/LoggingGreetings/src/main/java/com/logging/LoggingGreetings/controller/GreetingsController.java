package com.logging.LoggingGreetings.controller;

import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
// import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logging.LoggingGreetings.service.iGreetingsService;

@RestController
public class GreetingsController {
	
	// private static final Logger logger = LogManager.getLogger(GreetingsController.class);
	// this is a SpringBoot application, we haven't added any libraries for Logger in pom file
	// SL4J is specification , parent of Log4J
	
	private static final Logger logger = LoggerFactory.getLogger(GreetingsController.class);
	
	@Autowired
	private iGreetingsService service;
	/*
	 * 2024-11-21T22:23:42.664-05:00  INFO 14176 --- [LoggingGreetings] [nio-8080-exec-4] c.l.L.controller.GreetingsController     : Request into API
2024-11-21T22:23:42.664-05:00  INFO 14176 --- [LoggingGreetings] [nio-8080-exec-4] c.l.L.controller.GreetingsController     : Service method logic is invoked
	 */

	@GetMapping("/greetings")
	public ResponseEntity<?> getGreeting() {
		logger.info("Request into API");
		String wish = service.generateGreeting();
		logger.info("Service method logic is invoked");
		// by default, log levels enabled in SpringBoot application is info, warn, error not debug
		logger.debug("Debug logger");
		return new ResponseEntity<String>(wish, HttpStatus.OK);
		/*
		 * 2024-11-21T22:29:57.985-05:00  INFO 47424 --- [LoggingGreetings] [nio-8080-exec-2] c.l.L.controller.GreetingsController     : Request into API
		2024-11-21T22:29:57.986-05:00  INFO 47424 --- [LoggingGreetings] [nio-8080-exec-2] c.l.L.controller.GreetingsController     : Service method logic is invoked
		2024-11-21T22:29:57.986-05:00 DEBUG 47424 --- [LoggingGreetings] [nio-8080-exec-2] c.l.L.controller.GreetingsController     : Debug logger
		 */
	}
	
}
