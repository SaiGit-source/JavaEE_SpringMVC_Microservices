package Controller;

// this is a Servlet
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Model;

import java.io.IOException;

// Add external JAR file: add to Buildpath mysql-connector jar file
// also add to Deployment assembly because it is a web application -> click add -> java build path entries -> add mysql apply
// this app can be extended with another module: 'Login' module

// actual workflow is: view -> controller -> model -> view

public class RegisterApp extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("uname");
		String email = request.getParameter("uemail");
		String city = request.getParameter("ucity");
		String password = request.getParameter("upassword");
		
		// now we have the form data here in Controller how do i transfer this data into Model class so it can connect to database
		// through setters i would like to pass this data
		
		Model model = new Model();
		model.setName(name);
		model.setEmail(email);
		model.setCity(city);
		model.setPassword(password);
		// sending data to database through Model layer
		int row = model.register();
		
		// add data to Session. why? to access into JSP
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		session.setAttribute("email", email);
		
		if (row==0) 
		{
			// redirect response to a JSP page
			// no rows affected then failed
			// redirecting to View layer
			response.sendRedirect("/MVC_RegistrationApp/failed.jsp");	
		}
		else 
		{
			response.sendRedirect("/MVC_RegistrationApp/success.jsp");
		}
	
	}

}
