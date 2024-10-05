package com.jdbc.learning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLDeleteRecord {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// Load and Register the Driver
		
		Class.forName("com.mysql.cj.jdbc.Driver"); // load from DB vendor
		// this method is there to load the class
		
		// Establish the connection
		String url = "jdbc:mysql://localhost:3306/jdbclearning";
		String user= "root";
		String password = "MySQL123#";
		
		Connection connect = DriverManager.getConnection(url, user, password); // interface referring to implementing classes
		
		//creating statement
		Statement statement = connect.createStatement();
		
		//execute query
		// String sql = "DELETE FROM studentinfo1"; // this will delete all records from the table
		String sql = "DELETE FROM studentinfo1 where id=2";
		int rowAffected = statement.executeUpdate(sql); // for retrieving 
		
		// process the result
		
		if (rowAffected==0) {
			System.out.println("Delete operation failed");
		}
		else {
			System.out.println("Delete operation successful");
		}
		//close the resources
		
		statement.close();
		connect.close();

	}

}
