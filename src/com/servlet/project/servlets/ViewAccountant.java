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

import com.servlet.project.bean.AccountantBean;
import com.servlet.project.dao.AccountantDao;

@WebServlet("/ViewAccountant")
public class ViewAccountant extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		   PrintWriter out = resp.getWriter();
		   HttpSession session=req.getSession(false);
			if (session != null)
			{			System.out.println("no null");
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>View Student</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table border=\"1px solid\">");
		out.println("<tr>"
				+ "<th>Roll.No</th>"
				+ "<th>Name</th>"
				+ "<th>Email</th>"
				+ "<th>Password</th>"
				+ "<th>Address</th>"
				+ "<th>Contact</th>"
				+ "<th>Edit</th>"
				+ "<th>Delete</th>"				
				+ "</tr>");
		List<AccountantBean> list=AccountantDao.getAllRecords();
		for (AccountantBean bean : list) {
			out.print("<tr>"
					+ "<td>"+bean.getId()+"</td>"
					+"<td>"+bean.getName()+"</td>"
					+"<td>"+bean.getEmail()+"</td>"
					+"<td>"+bean.getPassword()+"</td>"
					+"<td>"+bean.getAddress()+"</td>"
					+"<td>"+bean.getContact()+"</td>"
					+"<td><a href='EditAccountantForm?ID="+bean.getId()+"'>Edit</a></td>"
					+"<td><a href='DeleteAccountant?ID="+bean.getId()+"'>Delete </a></td>"
						
					+"</tr>");			
		}	
			out.println("</table>");
			out.println("<a href='AdminHome.html'><=Back ");
			out.println("</body>");
			out.println("</html>");	
	}
			else {

				resp.sendRedirect("index.html");

			}

	}
	
}
