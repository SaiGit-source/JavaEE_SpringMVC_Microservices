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
 * Servlet implementation class FirstServlet
 */

// only service method is added here
// lets take request from client then we 'dispatch' request to Second Servlet then SecondServlet responds back to client
// two methods: forward and include -> Client request is forwarded to SecondServlet from FirstServlet so SecondServlet provides the entire response
// include() method, takes in response from Client and responds back to Client, which actually includes response from SecondServlet as well
// servlet chaining

public class FirstServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("Control in First Servlet");
		RequestDispatcher requestDispatch = request.getRequestDispatcher("/SecondServlet");
		requestDispatch.forward(request, response); // two methods: forward and include
		PrintWriter writer = response.getWriter();
		writer.println("<h1>Response from FirstServlet</h1>");
		writer.close();
		System.out.println("Control again in FirstServlet");
		
		// note when i enter http://localhost:8085/RequestDispatching/FirstServlet i get "Response from SecondServlet"
		// we have forwarded/dispatched the client request to SecondServlet
		// we are able to communicate between Servlets
		
		// include() method is FirstServlet only provides response to client but it includes response from SecondServlet also.
	}

}
