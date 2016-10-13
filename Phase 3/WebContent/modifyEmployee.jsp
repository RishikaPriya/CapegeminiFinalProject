<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.util.HashMap"%>
<%@page import="com.flp.ems.util.Service"%>
<%@page import="com.flp.ems.service.IEmployeeService"%>

<%!IEmployeeService employeeService = Service.getEmployeeService();%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modify Employee Details</title>
</head>
<body>
	<h3>Enter Employee Details to be Modified</h3>
	<form method="post">
		<table>
			<tr>
				<td>Employee ID:</td>
				<td><input type="text" name="employeeId" /></td>
			</tr>
			<tr>
				<td>Contact Number:</td>
				<td><input type="text" name="contact" /></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><textarea rows="2" cols="15" name="address"></textarea></td>
			</tr>
			<tr>
				<td>Department Id:</td>
				<td><input type="text" name="deptId" /></td>
			</tr>
			<tr>
				<td>Role Id:</td>
				<td><input type="text" name="roleId" /></td>
			</tr>
			<tr>
				<td>Project Id:</td>
				<td><input type="text" name="projectId" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Modify Employee" /></td>
			</tr>
		</table>
	</form>

	<%
		if (request.getMethod().equalsIgnoreCase("post")) {
			HashMap<String, String> employee = new HashMap<String, String>();
			employee.put("employeeId", request.getParameter("employeeId"));
			employee.put("phoneNumber", request.getParameter("contact"));
			employee.put("address", request.getParameter("address"));
			employee.put("deptId", request.getParameter("deptId"));
			employee.put("roleId", request.getParameter("roleId"));
			employee.put("projectId", request.getParameter("projectId"));

			employeeService.modifyEmployee(employee);
		}
	%>

</body>
</html>