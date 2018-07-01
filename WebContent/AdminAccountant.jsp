<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%	
	String name=request.getParameter("Acname");
	out.print(name.toUpperCase()+"  "+"details added successfully");
	String pass=request.getParameter("Acpassword");
	String email=request.getParameter("Acemail");
	String add=request.getParameter("Acaddress");
	String no=request.getParameter("Acnumber");
   %>
   <br>
   <%=" Check  details of Accountant " %>
   <table border="1px" >
   	<tr><td>Name</td><td><%=name%></td></tr>
   <tr><td>Password</td><td><%=pass%></td></tr>
   <tr><td>Email</td><td><%=email%></td></tr>
   <tr><td>Address</td><td><%=add%></td></tr>
   <tr><td>M-number</td><td><%=no%></td></tr>   
   </table>

  <a href="AdminHome.html">Back to</a>

</body>
</html>