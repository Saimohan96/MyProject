package com.servlet.project.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.project.dao.AccountantDao;
import com.servlet.project.dao.StudentDao;


@WebServlet("/DeleteAccountant")
public class DeleteAccountant extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idNo=req.getParameter("ID");
		int id = Integer.parseInt(idNo);
		boolean delete=AccountantDao.deleteById(id);
	    resp.sendRedirect("ViewAccountant");
	}
}
