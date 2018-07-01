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

@WebServlet("/EditStudentForm")
public class EditStudentForm extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		String idNo = req.getParameter("RollNo");
		int id = Integer.parseInt(idNo);
		StudentBean bean = StudentDao.getRecordById(id);
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Edit Student Form</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action='EditStudent' method='post'>");
		out.println("<table>" 
				+ "<tr><th>Roll.No</th>" + "<td><input type='NUMBER' name='id' value='" + bean.getId()+ "'></td></tr>"
				+ "<tr><th>Name</th><td><input type='text'  name='name' value='" + bean.getName() + "'></td></tr>"
				+ "<tr><th>Email</th><td><input type='text' name='email' value='" + bean.getEmail() + "'></td></tr>"
				+ "<tr><th>Gender</th><td><input type='text' name='gender' value='" + bean.getGender() + "'></td></tr>"
				+ "<tr><th>Course</th><td><input type='text' name='course' value='" + bean.getCourse() + "'></td></tr>"
				+ "<tr><th>Fee</th><td><input type='NUMBER'  name='fee' value='" + bean.getFee() + "'></td></tr>"
				+ "<tr><th>Paid</th><td><input type='NUMBER' name='paid' value='" + bean.getPaid() + "'></td></tr>"
				+ "<tr><th>Due</th><td><input type='NUMBER'  name='due' value='" + bean.getDue() + "'></td></tr>"
				+ "<tr><th>Address</th><td><input type='text' name='address' value='" + bean.getAddress() + "'></td></tr>"
				+ "<tr><th>Contact</th><td><input type='text' name='contact' value='" + bean.getContact()+ "'></td></tr>"
				+ "<tr align='center'><td><input type='submit' value='Submit'></td></tr>"
				+ "</table>" + "</form>" + ""
						+ "<a href='AccountantViewStudents'>back</a>"
						+ "</body>" + "</html>");
	}

}
