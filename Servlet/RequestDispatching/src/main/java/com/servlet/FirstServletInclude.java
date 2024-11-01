package com.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class FirstServletInclude
 */
public class FirstServletInclude extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("Control in First Servlet");
		RequestDispatcher requestDispatch = request.getRequestDispatcher("/SecondServlet");
		requestDispatch.include(request, response); // two methods: forward and include
		PrintWriter writer = response.getWriter();
		writer.println("<h1>Response from FirstServlet</h1>");
		writer.close();
		System.out.println("Control again in FirstServlet");
		
		// if i enter "http://localhost:8085/RequestDispatching/FirstServletInclude"
		// it prints "Response from SecondServlet"
		
		// include() method is FirstServlet only provides response to client but it includes response from SecondServlet also.
	}

}
