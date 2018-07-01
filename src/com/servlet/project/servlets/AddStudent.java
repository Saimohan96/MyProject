package com.servlet.project.servlets;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.project.bean.StudentBean;
import com.servlet.project.dao.StudentDao;

@WebServlet("/AddStudentData")
public class AddStudent extends HttpServlet {
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String gender=req.getParameter("gender");
		String contact=req.getParameter("contact");
		String address=req.getParameter("address");
		String course=req.getParameter("course");
		int fee=Integer.parseInt(req.getParameter("fee"));
		int paid=Integer.parseInt(req.getParameter("paid"));
		int due=fee-paid;
		StudentBean bean=new StudentBean(name,email,gender,contact,address,course,fee,paid,due);
		int update=StudentDao.save(bean);
		out.print("<!doctype html>"
				+ "<html>"
				+ "<body>"
				+ "Student added Successful"
				+ "</body>"
				+ "</html>");
		req.getRequestDispatcher("AccountantHome.html").include(req, resp);
		
		
	}
	
	
	
}
