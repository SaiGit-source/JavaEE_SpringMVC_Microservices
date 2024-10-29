package com.springboot.SpringDataJDBC;

import org.springframework.boot.SpringApplication;

// open h2 in-memory database here
// http://localhost:8484/h2-console/login.jsp?jsessionid=48de1556e1b630ca796d6c35ee0a301b
// url: jdbc:h2:mem:finisher

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.springboot.SpringDataJDBC.dao.EmployeeImpl;

@SpringBootApplication
public class SpringDataJdbcApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(SpringDataJdbcApplication.class, args);
		
		// following code is one approach
		//EmployeeImpl dao = container.getBean(EmployeeImpl.class);
		//dao.input();
		
		// second approach is CommandLineRunner
	}

}
