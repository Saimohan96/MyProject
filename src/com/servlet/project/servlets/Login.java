package com.servlet.project.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.servlet.project.dao.DBConnection;

@WebServlet("/LoginServ")
public class Login extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		HttpSession session=req.getSession();
		
		PrintWriter out = resp.getWriter();

		String name = req.getParameter("user");
		String password = req.getParameter("password");
		String userName = null;
		String pass = null;
		String acname = null;
		String acpass = null;
		Connection con = DBConnection.getDbConnection();
		try {
			PreparedStatement pspt = (PreparedStatement) con
					.prepareStatement("SELECT *FROM admin where UserName=? && Password=?");
			pspt.setString(1, name);
			pspt.setString(2, password);
			ResultSet rs1 = pspt.executeQuery();
			pspt.addBatch();
			while (rs1.next()) {
				userName = rs1.getString(2);
				pass = rs1.getString(3);
			}

			pspt = (PreparedStatement) con.prepareStatement("SELECT *FROM fee_accountant WHERE NAME=? && PASSWORD=?");
			pspt.setString(1, name);
			pspt.setString(2, password);
			System.out.println("psp 2");
			ResultSet rs2 = pspt.executeQuery();
			while (rs2.next()) {
				acname = rs2.getString(2);
				acpass = rs2.getString(4);
			}

			if (userName != null  && pass != null  )
			{
				if (userName.equals(name) && pass.equals(password))
				{
					session.setAttribute("adminUser",name);
					session.setAttribute("adminPass",password);
					
					//out.println(name.toUpperCase() + " Login Successful As a Admin");
					req.getRequestDispatcher("AdminHome.html").include(req, resp);
				}
							
				else
				{
					
					out.println("Login fail");
					out.println("Username or password is wrong");
					req.getRequestDispatcher("index.html").include(req, resp);
				}

			}
			else if(acname != null && acpass != null)
			{
				if (acname.equals(name) && acpass.equals(password))
				{		
					session.setAttribute("ActUser",name);
					session.setAttribute("ActPass",password);
										
			    	out.println(name.toUpperCase() + " Login Successful As a Accountant");
			    	req.getRequestDispatcher("AccountantHome.html").include(req, resp);
			   }	
				 else {
				
					out.println("Login fail");
					out.println("Username or password is wrong");
					req.getRequestDispatcher("index.html").include(req, resp);
				 }
		}
		}
			
			 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
