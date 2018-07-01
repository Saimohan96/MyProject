package com.servlet.project.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.project.bean.AccountantBean;
import com.servlet.project.dao.AccountantDao;

@WebServlet("/EditAccountantForm")
public class EditAccountantForm extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();

		String idNo = req.getParameter("ID");
		int id = Integer.parseInt(idNo);
		AccountantBean bean = AccountantDao.getRecordById(id);
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Edit Accountant Form</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action='EditAccountant' method='post'>");
		out.println("<table>" + "<tr><th>Roll.No</th>" + "<td><input type='NUMBER' name='id' value='" + bean.getId()
				+ "'></td></tr>" + "<tr><th>Name</th><td><input type='text'  name='name' value='" + bean.getName()
				+ "'></td></tr>" + "<tr><th>Email</th><td><input type='text' name='email' value='" + bean.getEmail()
				+ "'></td></tr>" + "<tr><th>Password</th><td><input type='text' name='password' value='"
				+ bean.getPassword() + "'></td></tr>"
				+ "<tr><th>Address</th><td><input type='text' name='address' value='" + bean.getAddress()
				+ "'></td></tr>" + "<tr><th>Contact</th><td><input type='text' name='contact' value='"
				+ bean.getContact() + "'></td></tr>"
				+ "<tr align='center'><td><input type='submit' value='Submit'></td></tr>" + "</table>" + "</form>"
				+ "<a href='ViewAccountant'>back</a>" + "</body>" + "</html>");

	}
}
