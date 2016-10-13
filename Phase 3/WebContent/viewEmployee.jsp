<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.util.List"%>
<%@page import="com.flp.ems.domain.Employee"%>
<%@page import="com.flp.ems.util.Service"%>
<%@page import="com.flp.ems.service.IEmployeeService"%>

<%!IEmployeeService employeeService = Service.getEmployeeService();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Employee</title>
</head>
<body>

	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<%
		List<Employee> list = employeeService.getAllEmployees();
		request.setAttribute("list", list);
	%>

	<table border=1>
		<tr>
			<th>Name</th>
			<th>KinId</th>
			<th>Contact Number</th>
			<th>Address</th>
			<th>EmailId</th>
		</tr>

		<c:forEach items="${list}" var="u">
			<tr>
				<td>${u.getName()}</td>
				<td>${u.getKinId()}</td>
				<td>${u.getPhoneNumber()}</td>
				<td>${u.getAddress()}</td>
				<td>${u.getEmailId()}</td>
			</tr>


		</c:forEach>

	</table>

</body>
</html>