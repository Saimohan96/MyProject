package com.servlet.project.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.project.dao.StudentDao;

@WebServlet("/DeleteStudent")
public class DeleteStudent extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idNo=req.getParameter("RollNo");
		int id = Integer.parseInt(idNo);
		boolean delete=StudentDao.deleteById(id);
		resp.sendRedirect("AccountantViewStudents");
		
		
	}
}
