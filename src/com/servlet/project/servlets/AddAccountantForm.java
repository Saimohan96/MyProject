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

@WebServlet("/AccountantServ")
public class AddAccountantForm  extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		
		String name=req.getParameter("Acname");
		String pass=req.getParameter("Acpassword");
		String email=req.getParameter("Acemail");
		String no=req.getParameter("Acnumber");
		String address=req.getParameter("Acaddress");
		
		AccountantBean bean = new AccountantBean(name,pass,email,no,address);
		int b=AccountantDao.save(bean);
		System.out.println("dopost at bean");
		
		req.getRequestDispatcher("AdminAccountant.jsp").include(req, resp);		
		
			
		
		
		
		
		
		
		
		
	}

}
