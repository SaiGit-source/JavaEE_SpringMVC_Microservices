package com.jdbc.learning;
import java.sql.*;

public class MySQLConnect {

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
		String sql = "INSERT INTO studentInfo1(id, sname, sage, scity) VALUES(2, 'Name2', 25, 'City2')";		
		int rowAffected = statement.executeUpdate(sql);
		
		if (rowAffected==0) {
			System.out.println("Unable to insert the data");
		} // if row Affected is 0 then no rows is affected
		else {
			System.out.println("Data inserted successfully");
		}
		//process the result
		
		//close the resources
		statement.close();
		connect.close();
		
	}

}
