package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class RegisterServletApp
 */
public class RegisterServletApp extends HttpServlet {

	// it is not a good programming practice to respond back to client directly this Servlet app or this method.
	// Servlet is only a controller -> code responsible to handle HTTP requests and send response. MVC pattern
	// job of the controller is only to serialize and de-serialize data for/from the client.
	// the HTML response code we have got is the 'view' part, whatever code client can see is the 'view' part.
	// Note HTML is not a programming language, it can only display some contents not like username variable etc that's why we need JSP
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// uname and ucity are like form variables. they come from HTML page
		String name = request.getParameter("uname");
		String city = request.getParameter("ucity");
	
		response.sendRedirect("/JSP_Redirection/RegistrationSuccess.jsp");
		// we are redirecting to JSP page instead of printing right here
		
		// going back to client
		PrintWriter writer = response.getWriter();
		// Dynamic response
		/* this also works
		writer.println("Hello "+name);
		writer.println("I see you are from "+city);
		better presentation with HTML code */
		// printing in better way
		// however, instead of writing HTML code in Servlet, we have to write a seperate HTML and JSP page to do the same thing, then we go to redirect the client response to that JSP page
		
		/*
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
				+ "			<td><th> Name</th> </td>\r\n"
				+ "			<td><th> " +name+ "</th> </td>\r\n"
				+ "		</tr>\r\n"
				+ "		\r\n"
				+ "		<tr>\r\n"
				+ "			<td><th> City </th></td>\r\n"
				+ "			<td><th> " +city+ "</th> </td>\r\n"
				+ "		</tr>\r\n"
				+ "		\r\n"
				+ "	</table>\r\n"
				+ "\r\n"
				+ "</body>\r\n"
				+ "</html>");
		
		
		writer.close();
		*/
	
	}

}
