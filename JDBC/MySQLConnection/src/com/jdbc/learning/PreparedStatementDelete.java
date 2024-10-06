package com.jdbc.learning;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PreparedStatementDelete {

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
		// String sql = "UPDATE studentinfo1 SET sage=? WHERE id=?";
		
		String sql = "DELETE FROM studentinfo1 WHERE id=?";
		prepStatement = connect.prepareStatement(sql);
		
		System.out.println("Please enter the following details to be stored in DB");
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter id row to be deleted: ");
		Integer id = scan.nextInt();
				
		prepStatement.setInt(1, id); // first placeholder in the query has integer datatype
		
		// int rowAffected = statement.executeUpdate(sql); this is for Statement objects
		
		int rowAffected = prepStatement.executeUpdate();
		//process the result
		
		if (rowAffected==0) {
			System.out.println("Delete failed!");
		} // if row Affected is 0 then no rows is affected
		else {
			System.out.println("Deleted successfully!");
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
