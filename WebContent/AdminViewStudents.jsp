<%@page import="java.sql.ResultSet"%>
<%@page import="com.mysql.jdbc.PreparedStatement"%>
<%@page import="com.servlet.project.dao.DBConnection"%>
<%@page import="com.mysql.jdbc.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student</title>
</head>
<h1>Student Details</h1>
<body>	
   <table border="1px solid">
		<tr>
			<td><%="ID"%></td>
			<td><%="NAME"%></td>
			<td><%="EMAIL"%></td>
			<td><%="GENDER"%></td>
			<td><%="COURSE"%></td>
			<td><%="FEE"%></td>
			<td><%="PAID"%></td>
			<td><%="DUE"%></td>
			<td><%="ADDRESS"%></td>
			<td><%="CONTACT"%></td>
	</tr>
		<%
		if (session != null) {
			Connection con = DBConnection.getDbConnection();
				PreparedStatement pspt = (PreparedStatement) con.prepareStatement("SELECT *FROM fee_student ");
				ResultSet rs = pspt.executeQuery();
				while (rs.next()) {%>
		<tr>
			<td><%=rs.getInt(1)%></td>
			<td><%=rs.getString(2)%></td>
			<td><%=rs.getString(3)%></td>
			<td><%=rs.getString(4)%></td>
			<td><%=rs.getString(5)%></td>
			<td><%=rs.getInt(6)%></td>
			<td><%=rs.getInt(7)%></td>
			<td><%=rs.getInt(8)%></td>
			<td><%=rs.getString(9)%></td>
			<td><%=rs.getString(10)%></td>
	</tr>
		<%}%>
			<%} 
			else {
				response.sendRedirect("index.html");
			}
			%> 		
	</table>
	<a href="AdminHome.html">Back to Admin_home</a>
</body>
</html>