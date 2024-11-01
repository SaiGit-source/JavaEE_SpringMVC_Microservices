package com.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

// i am keeping only the service() method

public class FirstServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Control in First Servlet");
		
		// collect data before dispatching
		String name = request.getParameter("uname");
		String city = request.getParameter("ucity");
		
		// how to give this data to second servlet? thats where session comes into picture and session will be given by Webserver that's Apache Tomcat
		
		HttpSession session = request.getSession();
		session.setAttribute("userName", name);
		session.setMaxInactiveInterval(10000); // this data will be available in the session for only one minute
		
		RequestDispatcher requestDispatch = request.getRequestDispatcher("/SecondServlet");
		
		
		requestDispatch.forward(request, response); // two methods: forward and include
		PrintWriter writer = response.getWriter();
		writer.println("<h1>Response from FirstServlet</h1>");
		writer.close();
		System.out.println("Control again in FirstServlet");

	}

}
