package com.servlet.project.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.servlet.project.bean.AccountantBean;
import com.servlet.project.bean.StudentBean;

public class AccountantDao {
	public static int save(AccountantBean bean) {
		System.out.println("save dao");
		int  noOfUpdated=0;
		Connection con = DBConnection.getDbConnection();
		try {
			PreparedStatement pspt=(PreparedStatement) con.prepareStatement("INSERT INTO fee_accountant(NAME,EMAIL,PASSWORD,ADDRESS,CONTACT) values(?,?,?,?,?) ");
			System.out.println("sai");
			pspt.setString(1,bean.getName());
			pspt.setString(2,bean.getEmail());
			pspt.setString(3,bean.getPassword());
			pspt.setString(4,bean.getAddress());
			pspt.setString(5,bean.getContact());
			
			noOfUpdated=pspt.executeUpdate();
			System.out.println("updated  "+noOfUpdated);			
			con.close();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return noOfUpdated;
		}
	public static AccountantBean getRecordById(int id) {
		AccountantBean bean = new AccountantBean();
		Connection con = DBConnection.getDbConnection();
		PreparedStatement pspt = null;
		ResultSet rs = null;
		try {
			pspt = (PreparedStatement) con.prepareStatement("SELECT *FROM fee_accountant  where ID=?");
			pspt.setInt(1,id);
			rs = pspt.executeQuery();
			while (rs.next()) {
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setPassword(rs.getString(4));
				bean.setAddress(rs.getString(5));
				bean.setContact(rs.getString(6));
			}con.close();pspt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean;
	}
	public static boolean deleteById(int id) {
		boolean value = false;
		Connection con=DBConnection.getDbConnection();
		try {
			PreparedStatement pspt=(PreparedStatement) con.prepareStatement("DELETE FROM 	fee_accountant where ID=?");
			pspt.setInt(1, id);
			value=pspt.execute();
			System.out.println(value);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return value;
	}
	public static int update(AccountantBean bean ) {
		int upDated=0;		
		Connection con=DBConnection.getDbConnection();
		try {
			PreparedStatement pspt;
			pspt=(PreparedStatement) con.prepareStatement("UPDATE fee_accountant SET NAME=?,EMAIL=?,PASSWORD=?,ADDRESS=?,CONTACT=? WHERE ID=?");
			pspt.setString(1, bean.getName());
			pspt.setString(2,bean.getEmail());
			pspt.setString(3, bean.getPassword());
			pspt.setString(4,bean.getAddress());
			pspt.setString(5,bean.getContact());
			pspt.setInt(6,bean.getId());
			upDated=pspt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return upDated;		
	}
	public static boolean deleteById1(int id) {
		boolean value = false;
		Connection con=DBConnection.getDbConnection();
		try {
			PreparedStatement pspt=(PreparedStatement) con.prepareStatement("DELETE FROM 	fee_accountant where ID=?");
			pspt.setInt(1, id);
			value=pspt.execute();
			System.out.println(value);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return value;
	}
	public static List<AccountantBean> getAllRecords() {
		List<AccountantBean> list = new ArrayList<AccountantBean>();
		Connection con = DBConnection.getDbConnection();
		PreparedStatement pspt;
		ResultSet rs = null;
		try {
			pspt = (PreparedStatement) con.prepareStatement("SELECT *FROM fee_accountant");
			rs = pspt.executeQuery();
			while (rs.next()) {
				AccountantBean bean = new AccountantBean();
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setPassword(rs.getString(4));
				bean.setAddress(rs.getString(5));
				bean.setContact(rs.getString(6));
				list.add(bean);
			}
			con.close();pspt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}


}
