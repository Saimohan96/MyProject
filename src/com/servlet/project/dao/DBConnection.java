package com.servlet.project.dao;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class DBConnection {
	
	public static Connection getDbConnection() {
		 Connection con=null;
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/feemanagement","root","mohan");
		} catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;}

}
