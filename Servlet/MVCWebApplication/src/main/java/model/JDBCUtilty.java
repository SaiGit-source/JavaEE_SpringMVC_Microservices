package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// regular Java class

public class JDBCUtilty 
{
	// common operations: establishing connection, loading and registering driver, closing resources
	
	// step 1: load and register driver
	static 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // add jar file
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Driver is registered");
	
	}
	
	public static Connection getDBConnection() throws SQLException
	{
		String url="jdbc:mysql://localhost:3306/finishers";
		String dbuser="root";
		String dbpassword="MySQL123#";
		// add to Buildpath 
		// also add to Deployment assembly because it is a web application -> add -> java build path entries -> add mysql apply
		
		// step2: get connection
		Connection connect = DriverManager.getConnection(url, dbuser, dbpassword);
		return connect;
	}
	
	public static void closeResource(Connection connect, Statement stmt) throws SQLException
	{
		if (connect!=null) {
			connect.close();
		}
		if (stmt!=null)
		{
			stmt.close();
		}
	}

}
