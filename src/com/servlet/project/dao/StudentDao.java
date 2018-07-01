package com.servlet.project.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.servlet.project.bean.StudentBean;

public class StudentDao {

	public static int save(StudentBean bean) {
		int updated = 0;
		Connection con = DBConnection.getDbConnection();
		try {
			PreparedStatement pspt = (PreparedStatement) con.prepareStatement(
					"INSERT INTO " + "fee_student(NAME,EMAIL,GENDER,COURSE,FEE,PAID,DUE,ADDRESS,CONTACT)"
							+ " values( ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			pspt.setString(1, bean.getName());
			pspt.setString(2, bean.getEmail());
			pspt.setString(3, bean.getGender());
			pspt.setString(4, bean.getCourse());
			pspt.setInt(5, bean.getFee());
			pspt.setInt(6, bean.getPaid());
			pspt.setInt(7, bean.getDue());
			pspt.setString(8, bean.getAddress());
			pspt.setString(9, bean.getContact());
			updated = pspt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updated;

	}
	public static boolean deleteById(int id) {
		boolean value = false;
		Connection con=DBConnection.getDbConnection();
		try {
			PreparedStatement pspt=(PreparedStatement) con.prepareStatement("DELETE FROM 	fee_student where ROLLNO=?");
			pspt.setInt(1, id);
			value=pspt.execute();
			System.out.println(value);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return value;
	}

	public static List<StudentBean> getAllRecords() {
		List<StudentBean> list = new ArrayList<StudentBean>();
		Connection con = DBConnection.getDbConnection();
		PreparedStatement pspt;
		ResultSet rs = null;
		try {
			pspt = (PreparedStatement) con.prepareStatement("SELECT *FROM fee_student");
			rs = pspt.executeQuery();
			while (rs.next()) {
				StudentBean bean = new StudentBean();
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setGender(rs.getString(4));
				bean.setCourse(rs.getString(5));
				bean.setFee(rs.getInt(6));
				bean.setPaid(rs.getInt(7));
				bean.setDue(rs.getInt(8));
				bean.setAddress(rs.getString(9));
				bean.setContact(rs.getString(10));
				list.add(bean);
			}
			con.close();pspt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public static StudentBean getRecordById(int id) {
		StudentBean bean = new StudentBean();
		Connection con = DBConnection.getDbConnection();
		PreparedStatement pspt = null;
		ResultSet rs = null;
		try {
			pspt = (PreparedStatement) con.prepareStatement("SELECT *FROM fee_student  where ROLLNO=?");
			pspt.setInt(1,id);
			rs = pspt.executeQuery();
			while (rs.next()) {
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setGender(rs.getString(4));
				bean.setCourse(rs.getString(5));
				bean.setFee(rs.getInt(6));
				bean.setPaid(rs.getInt(7));
				bean.setDue(rs.getInt(8));
				bean.setAddress(rs.getString(9));
				bean.setContact(rs.getString(10));
			}con.close();pspt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean;
	}
	public static List<StudentBean> getReport() {
		List<StudentBean> list=new ArrayList<StudentBean>();
		 Connection con=DBConnection.getDbConnection();
		 try {
			PreparedStatement pspt=(PreparedStatement) con.prepareStatement("SELECT *FROM fee_student WHERE DUE>0");
			ResultSet rs=pspt.executeQuery();
			while(rs.next()) {
				StudentBean bean=new StudentBean();
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setCourse(rs.getString(5));
				bean.setFee(rs.getInt(6));
				bean.setPaid(rs.getInt(7));
				bean.setDue(rs.getInt(8));
				list.add(bean);}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return list;		
	}
	public static int updateStudent(StudentBean bean ) {
		int upDated=0;		
		Connection con=DBConnection.getDbConnection();
		try {
			PreparedStatement pspt;
			pspt=(PreparedStatement) con.prepareStatement("UPDATE fee_student SET NAME=?,EMAIL=?,GENDER=?,COURSE=?,FEE=?,PAID=?,DUE=?,ADDRESS=?,CONTACT=? WHERE RollNo=?");
			pspt.setString(1, bean.getName());
			pspt.setString(2,bean.getEmail());
			pspt.setString(3, bean.getGender());
			pspt.setString(4,bean.getCourse());
			pspt.setInt(5,bean.getFee());
			pspt.setInt(6,bean.getPaid());
			pspt.setInt(7,bean.getDue());
			pspt.setString(8,bean.getAddress());
			pspt.setString(9,bean.getContact());
			pspt.setInt(10,bean.getId());
			upDated=pspt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return upDated;		
	}
	

}
