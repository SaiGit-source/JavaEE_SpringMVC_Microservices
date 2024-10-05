package com.jdbc.learning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLUpdateMethod {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
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
		String sql = "UPDATE studentinfo1 set sage=24 where id=2";
		
		int rowAffected = statement.executeUpdate(sql);
		if (rowAffected==0) {
			System.out.println("Update query failed");
		}
		else {
			System.out.println("Update successful");
		}
		
		//process the result
		
		//close the resources
		statement.close();
		connect.close();


	}

}
