package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletAppn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet controller GET method");
		
		String name = request.getParameter("uname");
		String city = request.getParameter("ucity");
		
		// data will be sent via url: http://localhost:8085/GetPost/ServletAppn?uname=Abc&ucity=Cincinatti
		// GET method is less secure because data got in URL -> not safe
		if (name.equals("Abc") && city.equals("Cincinatti"))
		{
			System.out.println("Success! the person is authenticated "+name);
		}
		else 
		{
			System.out.println("Person is not authenticated "+name);
		}

	}

	// when we change to "post", http://localhost:8085/GetPost/ServletAppn data is not passed in url. so POST method is safer
	// i want to pass in data securely so POST method
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("Servlet controller POST method");
		
		String name = request.getParameter("uname");
		
		String city = request.getParameter("ucity");
		
		// data will be sent via url: http://localhost:8085/GetPost/ServletAppn?uname=Abc&ucity=Cincinatti
		if (name.equals("Abc") && city.equals("Cincinatti"))
		{
			System.out.println("Success! the person is authenticated "+name);
		}
		else 
		{
			System.out.println("Person is not authenticated "+name);
		}
	
	}

}
