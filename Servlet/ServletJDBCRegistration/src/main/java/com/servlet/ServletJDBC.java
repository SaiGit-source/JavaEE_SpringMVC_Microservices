package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ServletJDBC extends HttpServlet {
	// we can use doPost or service

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("Controller: Control in Servlet");
		String name = request.getParameter("uname");
		String email = request.getParameter("uemail");
		String password = request.getParameter("upassword");
		String city = request.getParameter("ucity");
		
		// to store in DB, we got to create a DB and table
		
		// step 1: load and register driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // add jar file
			String url="jdbc:mysql://localhost:3306/finishers";
			String dbuser="root";
			String dbpassword="MySQL123#";
			// add to Buildpath 
			// also add to Deployment assembly because it is a web application -> add -> java build path entries -> add mysql apply
			
			// step2: get connection
			Connection connect = DriverManager.getConnection(url, dbuser, dbpassword);
			
			// step3: get Prepared statement
			String sql = "INSERT INTO PersonServlet (name, email, password, city) VALUES (?,?,?,?)";
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.setString(1, name);
			statement.setString(2, email);
			statement.setString(3, password);
			statement.setString(4, city);
			
			int rowsAffected=statement.executeUpdate();
			
			PrintWriter writer = response.getWriter();
			
			if (rowsAffected!=0) {
				writer.println("<html>\r\n"
						+ "<head>\r\n"
						+ "<meta charset=\"UTF-8\">\r\n"
						+ "<title>Dynamic web application</title>\r\n"
						+ "</head>\r\n"
						+ "<body bgcolor=\"green\" style=\"align-content: center\">\r\n"
						+ "<h1>Welcome to our Dynamic web application</h1>\r\n"
						+ "<h2>Dynamic response generated!</h2>\r\n"
						+ "	<table>\r\n"
						+ "		<tr>\r\n"
						+ "			<td><th> Registration successful!! </th> </td>\r\n"
						+ "		</tr>\r\n"
						+ "		<tr>\r\n"
						+ "			<td><th> " +rowsAffected + "</th> </td>\r\n"
						+ "		</tr>\r\n"
						+ "		\r\n"
						+ "	</table>\r\n"
						+ "\r\n"
						+ "</body>\r\n"
						+ "</html>");
				
			}
			else 
			{
				writer.println("<html>\r\n"
						+ "<head>\r\n"
						+ "<meta charset=\"UTF-8\">\r\n"
						+ "<title>Dynamic web application</title>\r\n"
						+ "</head>\r\n"
						+ "<body bgcolor=\"red\" style=\"align-content: center\">\r\n"
						+ "<h1>Welcome to our Dynamic web application</h1>\r\n"
						+ "<h2>Dynamic response generated!</h2>\r\n"
						+ "	<table>\r\n"
						+ "		<tr>\r\n"
						+ "			<td><th> Registration failed!! </th> </td>\r\n"
						+ "		</tr>\r\n"
						+ "		\r\n"
						+ "	</table>\r\n"
						+ "\r\n"
						+ "</body>\r\n"
						+ "</html>");
			}
			writer.close();
			connect.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
