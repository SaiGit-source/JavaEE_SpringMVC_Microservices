package com.jdbc.learning;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// PreparedStatement is for parameterized query

public class PreparedStatementExample {

	public static void main(String[] args) {

		Connection connect = null;
		Statement statement = null;
		PreparedStatement prepStatement = null;
		
		try {
		
		// Establish the connection
		connect = JDBCUtil.getConnection();
		
		//creating statement
		// statement = connect.createStatement();
		// instead of createStatement, we go with preparedStatement
		

		
		//execute query
		String sql = "INSERT INTO studentInfo1(id, sname, sage, scity) VALUES(?,?,?,?)";		
		
		prepStatement = connect.prepareStatement(sql);
		
		System.out.println("Please enter the following details to be stored in DB");
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter your id: ");
		Integer id = scan.nextInt();
		
		System.out.print("Enter your name: ");
		String name = scan.next();
		
		System.out.print("Enter your age: ");
		Integer age = scan.nextInt();
		
		System.out.print("Enter your city: ");
		String city = scan.next();
		
		prepStatement.setInt(1, id); // first placeholder in the query has integer datatype
		prepStatement.setString(2, name);
		prepStatement.setInt(3, age);
		prepStatement.setString(4, city);
		
		// int rowAffected = statement.executeUpdate(sql);
		
		int rowAffected = prepStatement.executeUpdate();
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
			JDBCUtil.closeResource(connect, prepStatement);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	}

}
