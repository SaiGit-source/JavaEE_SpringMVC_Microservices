package com.jdbc.learning;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Statement;

// here lets try to handle exceptions instead of ducking. Ducking is not good

public class MySQLHandlingExeception {

	public static void main(String[] args) {
		// Load and Register the Driver
		Connection connect = null;
		Statement statement = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			  
		// load from DB vendor
		// this method is there to load the class
		
		// Establish the connection
		String url = "jdbc:mysql://localhost:3306/jdbclearning";
		String user= "root";
		String password = "MySQL123#";
		
		connect = DriverManager.getConnection(url, user, password); // interface referring to implementing classes
		
		//creating statement
		statement = connect.createStatement();
		
		//execute query
		String sql = "INSERT INTO studentInfo1(id, sname, sage, scity) VALUES(2, 'Name2', 28, 'Charlotte')";		
		int rowAffected = statement.executeUpdate(sql);
		
		//process the result
		
		if (rowAffected==0) {
			System.out.println("Unable to insert the data");
		} // if row Affected is 0 then no rows is affected
		else {
			System.out.println("Data inserted successfully");
		}
	}
	catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	finally
	{
		// doesn't matter exception is handled or not it will get executed

		//close the resources
		try {
			statement.close();
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}

}


