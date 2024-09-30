package com.jdbc.learning;

import java.sql.DriverManager;
import java.sql.SQLException;

public class classForNameEx {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver"); // this code loads the class so static methods are loaded
		// DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		


	}

}
