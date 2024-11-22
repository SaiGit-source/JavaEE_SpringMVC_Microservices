package com.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//Log4J is from Apache so we add dependencies into package
//Log4J versions must match in pom: 2.17.1

/*
 * 2024-11-21 18:36:45,552 - com.logging.Log4JTest - [process] - (INFO) - INFO METHOD -
2024-11-21 18:36:45,555 - com.logging.Log4JTest - [process] - (WARN) - WARN METHOD -
2024-11-21 18:36:45,555 - com.logging.Log4JTest - [process] - (ERROR) - ERROR METHOD -
2024-11-21 18:36:45,555 - com.logging.Log4JTest - [process] - (FATAL) - FATAL METHOD -

 */


public class Log4JTest {
	// this is the class i want to monitor;
	private static final Logger logger = LogManager.getLogger(Log4JTest.class);
	
	public static void main(String[] args) {
			process();
	}
	
	
	public static void process() {
		
		// Service layer or any business logic
		// look into log4j2.xml
		// these are the log levels
		logger.trace("FROM THE TRACE METHOD");
		logger.debug("DEBUG METHOD");
		logger.info("INFO METHOD");
		logger.warn("WARN METHOD");
		logger.error("ERROR METHOD");
		logger.fatal("FATAL METHOD");
	}

}
