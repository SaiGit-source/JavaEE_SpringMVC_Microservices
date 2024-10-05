package com.jdbc.learning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLRetriveData {

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
		String sql = "SELECT * FROM studentinfo1";
		
		ResultSet rs = statement.executeQuery(sql); // for retrieving 
		
		// process the result
		while (rs.next()) {
			// int id = rs.getInt(1); // specify either column index or column name
			// System.out.println(rs.getInt(1)+ " "+ rs.getString(2) + " " + rs.getInt(3) + " " + rs.getString(4)); // first column datatype is int, second is string, third int, fourth string
			System.out.println(rs.getInt("id")+ " "+ rs.getString("sname") + " " + rs.getInt("sage") + " " + rs.getString("scity"));
		}
		
		//close the resources
		rs.close();
		// statement.close();
		connect.close();

	}

}
