package com.springboot.SpringJDBC.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.SpringJDBC.model.Employee;

@Repository("dao")
public class EmployeeDaoImpl implements EmployeeDaoInterface 
{
	@Autowired
	private DataSource dataSource;
	// this is used in JDBC: 		
	// Connection connect = DriverManager.getConnection(url, user, password); // interface referring to implementing classes
	// register driver and create connection are escaped here compared to JDBC
	private String SQL_QUERY="SELECT * FROM Employees;";
	List<Employee> employees = null;

	@Override
	public List<Employee> getEmployeeInfo() {
		System.out.println("DataSource impl is: "+dataSource.getClass().getName());

		try {
			Connection connection = dataSource.getConnection();
			System.out.println("Connection impl is "+ connection.getClass().getName());
			PreparedStatement statement = connection.prepareStatement(SQL_QUERY);
			ResultSet rs = statement.executeQuery();
			employees = new ArrayList<>();
			
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setCity(rs.getString(3));
				employees.add(emp);
			}
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employees;
	}
	
}
