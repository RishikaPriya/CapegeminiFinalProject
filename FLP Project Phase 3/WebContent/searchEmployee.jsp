<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.util.Date"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.lang.String"%>
<%@page import="com.flp.ems.util.Service"%>
<%@page import="com.flp.ems.service.IEmployeeService"%>

<%!IEmployeeService employeeService = Service.getEmployeeService();%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Employee</title>
</head>
<body>
	<h3>Enter Employee Id to be Searched</h3>
	<form method="post">
		<table>
			<tr>
				<td>Employee ID:</td>
				<td><input type="text" name="employeeId" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Search Employee" /></td>
			</tr>
		</table>
	</form>

	<%
		if (request.getMethod().equalsIgnoreCase("post")) {
			Integer employeeId = Integer.parseInt(request.getParameter("employeeId"));
			employeeService.searchEmployee(employeeId);
		}
	%>
</body>
</html>