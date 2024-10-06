package com.jdbc.learning;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
// batch updates all records in one go
// the performance is high
// it works only for non-select queries: insert, delete and update

public class BatchUpdate {

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
				
		prepStatement.setInt(1, 20); // first placeholder in the query has integer datatype
		prepStatement.setInt(2, 2);
		
		prepStatement.addBatch(); // add to the batch
	
		prepStatement.setInt(1, 25); // first placeholder in the query has integer datatype
		prepStatement.setInt(2, 3);
		
		prepStatement.addBatch(); // add to the batch
		
		prepStatement.setInt(1, 28); // first placeholder in the query has integer datatype
		prepStatement.setInt(2, 6);
		
		prepStatement.addBatch(); // add to the batch

		prepStatement.setInt(1, 30); // first placeholder in the query has integer datatype
		prepStatement.setInt(2, 5);
		
		prepStatement.addBatch(); // add to the batch
		
		prepStatement.executeBatch(); // instead of executeUpdate(), we are using executeBatch()
		System.out.println("Check the DB table to see the result");
		
		// int rowAffected = statement.executeUpdate(sql);
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
