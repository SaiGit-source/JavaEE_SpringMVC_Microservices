package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class SecondServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Control in SecondServlet");
		
		HttpSession session = request.getSession(false);
		String userName = (String) session.getAttribute("userName");
		
		PrintWriter writer = response.getWriter();
		writer.println("<h1>Response from SecondServlet</h1>");
		writer.println("<h1>" + userName + "</h1>");
		writer.close();

	}

}
