package com.jdbc.learning;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PreparedStatementUpdate {

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
		// String sql = "INSERT INTO studentInfo1(id, sname, sage, scity) VALUES(?,?,?,?)";		
		String sql = "UPDATE studentinfo1 SET sage=? WHERE id=?";
		prepStatement = connect.prepareStatement(sql);
		
		System.out.println("Please enter the following details to be stored in DB");
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter id to be updated: ");
		Integer id = scan.nextInt();
				
		System.out.print("Enter new age to be updated: ");
		Integer age = scan.nextInt();
				
		prepStatement.setInt(2, id); // first placeholder in the query has integer datatype
		prepStatement.setInt(1, age);
		
		// int rowAffected = statement.executeUpdate(sql);
		
		int rowAffected = prepStatement.executeUpdate();
		//process the result
		
		if (rowAffected==0) {
			System.out.println("Update failed!");
		} // if row Affected is 0 then no rows is affected
		else {
			System.out.println("Updated successfully!");
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
