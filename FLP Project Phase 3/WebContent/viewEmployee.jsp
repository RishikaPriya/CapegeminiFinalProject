<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="java.lang.String"%>
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

	<%
	List<Employee> empList = employeeService.getAllEmployees();
	for(Employee emp : empList){
		System.out.println(emp.toString());
	}
	%>
	
</body>
</html>