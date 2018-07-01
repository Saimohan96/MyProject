package com.servlet.project.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.servlet.project.bean.StudentBean;
import com.servlet.project.dao.StudentDao;

@WebServlet("/SearchStudent")
public class SearchStudent extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    PrintWriter out=resp.getWriter();
	    HttpSession session = req.getSession(false);
		if (session != null) {
		String idnumber=req.getParameter("id");
		int id=Integer.parseInt(idnumber);
		StudentBean bean=StudentDao.getRecordById(id);
		out.println("<!doctype html>");
		out.println("<html>"
				+ "<head><title>Search Student</title></head>"
				+ "<body>"+"<table border=\"1pr solid\">");
		out.println("<tr>"
				+ "<th>Id</th>"
				+ "<th>Name</th>"
				+ "<th>Email</th>"
				+ "<th>Gender</th>"
				+ "<th>Course</th>"
				+ "<th>Fee</th>"
				+ "<th>Paid</th>"
				+ "<th>Due</th>"
				+ "<th>Address</th>"
				+ "<th>Contact</th>"
				+ "<th>Edit</th>"
				+ "<th>Delete</th> </tr>");
		out.println("<tr>"
				+ "<td>"+bean.getId()+"</td>"
				+ "<td>"+bean.getName()+"</td>"
				+ "<td>"+bean.getEmail()+"</td>"
				+"<td>"+bean.getGender()+"</td>"
				+ "<td>"+bean.getCourse()+"</td>"
				+ "<td>"+ bean.getFee()+"</td>"
				+ "<td>"+bean.getPaid()+"</td>"
				+ "<td>"+bean.getDue()+"</td>"
				+ "<td>"+bean.getAddress()+"</td>"
				+ "<td>"+bean.getContact()+"</td>"
				+"<td><a href='EditStudent'>Edit</td>"
				+"<td><a href='DeleteStudent'>Delete</td>"
				+ "</tr>");
		out.println("</table>"
				+"<a href='AccountantHome.html'><=Back"
				+ "</body>"
				+ "</html>");
		}
		else {

			resp.sendRedirect("index.html");

		}
	
	
	}

}
