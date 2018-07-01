package com.servlet.project.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.servlet.project.bean.StudentBean;
import com.servlet.project.dao.StudentDao;

@WebServlet("/AdminFeeReport")
public class AdminFeeReport extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession(false);
		if (session != null) {
		List<StudentBean> list = StudentDao.getReport();
		out.println("<!doctype html" + "<html>" + "<body>" + "<table border='1px solid'>");
		out.println("<tr>" + "<th>ID</th>" + "<th>Name</th>" + "<th>Course</th>" + "<th>Fee</th>" + "<th>Paid</th>"
				+ "<th>Due</th>" + "</tr>");
		for (StudentBean bean : list) {
			out.println("<tr><td>" + bean.getId() + "</td><td>" + bean.getName() + "</td><td>" + bean.getCourse()
					+ "</td><td>" + bean.getFee() + "</td><td>" + bean.getPaid() + "</td><td>" + bean.getDue()
					+ "</td><td>" + "</td></tr>");
		}
		out.println("</table>"
				+ "<a href='AdminHome.html'><=back</a>"
				+ "</body>"
				+ "</html>");
		}else {

			resp.sendRedirect("index.html");

		}
	}

}
