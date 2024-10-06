package com.jdbc.learning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLCodeStructure {

	public static void main(String[] args) {
		// Load and Register the Driver
		Connection connect = null;
		Statement statement = null;
		
		try {
		
		// Establish the connection
		connect = JDBCUtil.getConnection();
		
		//creating statement
		statement = connect.createStatement();
		
		//execute query
		String sql = "INSERT INTO studentInfo1(id, sname, sage, scity) VALUES(5, 'Name2', 31, 'Raleigh')";		
		int rowAffected = statement.executeUpdate(sql);
		
		//process the result
		
		if (rowAffected==0) {
			System.out.println("Unable to insert the data");
		} // if row Affected is 0 then no rows is affected
		else {
			System.out.println("Data inserted successfully");
		}
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
			JDBCUtil.closeResource(connect, statement);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	}

}
