package com.servlet;

/*
 * initially static block is only executed
 * later Server container or web container will only create object of this Servlet class, we dont create an object
 * during object creation, this class Constructor will be executed
 * Class will be loaded and object will be created, later init method will be called
 * if you want to initialize any of the data, then write within init() method, Servet will call init method in the background
 * for each request from the client, service() method will be executed
 * after server is stopped, internally destroy() method will be called
 * Servlet program/application will be destroyed
 * for every client request, one thread internally is created and service() method is called
 * if you want to execute only once, then static, constructor or init method is good
 * 
 */

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ServletLifeCycle
 */

//@WebServlet("/ServerLifeCycle") // URL mapping if anyone wants to access this application
// if you dont write this, extends HttpServlet -> then it's not a Servlet, either extend 'HttpServlet' class or implement Servlet interface
public class ServletLifeCycle extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	// in Java, static block gets executed when a class is loaded
	static
	{
		System.out.println("static block: Servlet is loaded");
	}
	
	public ServletLifeCycle() {
		super();
		System.out.println("Constructor: Servlet object is instantiated");
	}

	public void init(ServletConfig config) throws ServletException 
	{
		System.out.println("Init method: Servlet initialized");
		
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service() method: Service method to handle http request and to respond back");
	}

}
