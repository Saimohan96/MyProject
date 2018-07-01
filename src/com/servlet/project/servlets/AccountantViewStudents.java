package com.servlet.project.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.servlet.project.bean.StudentBean;
import com.servlet.project.dao.StudentDao;

@WebServlet("/AccountantViewStudents")
public class AccountantViewStudents extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession(false);
		if (session != null) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>View Student</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<table border=\"1px solid\">");
			out.println("<tr>" + "<th>Roll.No</th>" + "<th>Name</th>" + "<th>Email</th>" + "<th>Gender</th>"
					+ "<th>Course</th>" + "<th>Fee</th>" + "<th>Paid</th>" + "<th>Due</th>" + "<th>Address</th>"
					+ "<th>Contact</th>" + "<th>Edit</th>" + "<th>Delete</th>" + "</tr>");
			List<StudentBean> list = StudentDao.getAllRecords();
			for (StudentBean bean : list) {
				out.print("<tr>" + "<td>" + bean.getId() + "</td>" + "<td>" + bean.getName() + "</td>" + "<td>"
						+ bean.getEmail() + "</td>" + "<td>" + bean.getGender() + "</td>" + "<td>" + bean.getCourse()
						+ "</td>" + "<td>" + bean.getFee() + "</td>" + "<td>" + bean.getPaid() + "</td>" + "<td>"
						+ bean.getDue() + "</td>" + "<td>" + bean.getAddress() + "</td>" + "<td>" + bean.getContact()
						+ "</td>" + "<td><a href='EditStudentForm?RollNo=" + bean.getId() + "'>Edit Student</a></td>"
						+ "<td><a href='DeleteStudent?RollNo=" + bean.getId() + "'>Delete Student</a></td>"

						+ "</tr>");
			}

			out.println("</table>");
			out.println("<a href='AccountantHome.html'><=Back ");
			out.println("</body>");
			out.println("</html>");
		} 
		else {

			resp.sendRedirect("index.html");

		}
	}
}
