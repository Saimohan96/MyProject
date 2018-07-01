package com.servlet.project.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.project.bean.AccountantBean;
import com.servlet.project.bean.StudentBean;
import com.servlet.project.dao.AccountantDao;
import com.servlet.project.dao.StudentDao;


@WebServlet("/EditAccountant")
public class EditAccountant extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String contact=req.getParameter("contact");
		String address=req.getParameter("address");
		AccountantBean bean=new AccountantBean(id,name,email,password,contact,address);
		int upDated=AccountantDao.update(bean);
		if(upDated>0)
		{				
			resp.sendRedirect("ViewAccountant");
		}
		else {
			resp.sendRedirect("EditAccountantForm");
			
		}
			
		
		
	}

}
