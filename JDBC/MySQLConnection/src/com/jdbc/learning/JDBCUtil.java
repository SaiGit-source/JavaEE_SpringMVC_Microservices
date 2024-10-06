package com.jdbc.learning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {		
			e.printStackTrace();
		}
	// load from DB vendor
	// this method is there to load the class
	}

	public static Connection getConnection() throws SQLException { // here we can duck it because whoever uses this class will handle it
		String url = "jdbc:mysql://localhost:3306/jdbclearning";
		String user= "root";
		String password = "MySQL123#";
		return DriverManager.getConnection(url, user, password); // interface referring to implementing classes
	}
	
	public static void closeResource(Connection connect, Statement statement) throws SQLException {
		statement.close();
		connect.close();
	}

}
