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

@WebServlet("/EditStudent")
public class EditStudent extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String gender=req.getParameter("gender");
		String contact=req.getParameter("contact");
		String address=req.getParameter("address");
		String course=req.getParameter("course");
		int fee=Integer.parseInt(req.getParameter("fee"));
		int paid=Integer.parseInt(req.getParameter("paid"));
		int due=fee-paid;
		StudentBean bean=new StudentBean(id,name, email, gender, contact, address, course, fee, paid, due);
		int upDated=StudentDao.updateStudent(bean);
			if(upDated>0)
		{				
			resp.sendRedirect("AccountantViewStudents");
		}
		else {
			resp.sendRedirect("EditStudentForm");
			
		}
			
	}
}
