package com.jdbc.learning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLExecuteMethod {

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
		String sql = "SELECT * FROM studentinfo1";	
		String sqlUpdate = "UPDATE studentinfo1 SET sage=16 where id=1"; // non-select method	 
		// boolean status = statement.execute(sql); // this is only for select methods
		boolean status = statement.execute(sqlUpdate); // this is only for select methods, for non-select methods, it will return false
		//process the result
		
		if (status) {
			//select
			ResultSet rs = statement.getResultSet();
			while (rs.next()) {
				System.out.println(rs.getInt(1)+ " " + rs.getString(2) + " "+ rs.getInt(3) + " "+rs.getString(4));
			}
		}
		else {
			//insert, update, delete
			int rows = statement.getUpdateCount();
			if(rows==0) {// rows affected
				System.out.println("Operation failed!");
			}
			else {
				System.out.println("Operation successful!");
			}
		}
		
		//close the resources
		statement.close();
		connect.close();

	}

}
