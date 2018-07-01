package com.servlet.project.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AccountantServLogin")
public class AccountantLogin extends HttpServlet {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		
		String name=req.getParameter("AccountantUser");	
	    String password=req.getParameter("AccountantPassword");
	    System.out.println(name);
	    System.out.println(password);
	    out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Accountant Panel</title>");
		out.println("</head>"); 
		out.println("<body>");
			  System.out.println("done");
	  
	    if(name.equals("as") && password.equals("as")) {
	    	out.print(" Login Successful");
	    	System.out.println("login level");
	    	req.getRequestDispatcher("AccountantHome.html").include(req, resp);
	    }
	    else {
	    	out.println("login Fail");
			out.println("Username or Password is wrong");    	
	    	req.getRequestDispatcher("index.html").include(req, resp);
	    }out.println("</body>");
	     out.println("</html>");
	}

}
