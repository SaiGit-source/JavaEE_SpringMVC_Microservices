package com.springboot.SpringDataJDBC.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.SpringDataJDBC.model.Employee;

@Repository("dao") // bean id is dao
public class EmployeeImpl 
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	//private String sql = "INSERT INTO Employee(id, name, city) VALUES (1,'Name123', 'Nashville');"; 
	private String sql = "INSERT INTO Employee(id, name, city) VALUES (?,?,?);"; 
	// connection, prepared statement not required
	
	public void input(Employee emp)
	{
		jdbcTemplate.update(sql, emp.getId(), emp.getName(), emp.getCity());
		
		System.out.println("Data inserted");
	}
	
	
	

}
