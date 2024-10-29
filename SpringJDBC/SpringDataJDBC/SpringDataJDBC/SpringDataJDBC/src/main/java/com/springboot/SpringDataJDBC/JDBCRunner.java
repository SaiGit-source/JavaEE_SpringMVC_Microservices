package com.springboot.SpringDataJDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springboot.SpringDataJDBC.dao.EmployeeImpl;
import com.springboot.SpringDataJDBC.model.Employee;

@Component
public class JDBCRunner implements CommandLineRunner {
	
	@Autowired
	private EmployeeImpl dao;
	
	// whatever you write inside run() method will be executed first
	@Override
	public void run(String... args) throws Exception 
	{
		
		dao.input(new Employee(2, "nameNew", "Atlanta"));	

	}

}
