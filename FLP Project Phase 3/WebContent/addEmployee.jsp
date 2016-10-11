<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.lang.String"%>
<%@page import="com.flp.ems.service.IEmployeeService"%>
<%@page import="com.flp.ems.util.Service"%>

<%!IEmployeeService employeeService = Service.getEmployeeService();%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee Form</title>
</head>
<body>
	<jsp:include page="EmployeeForm.html"></jsp:include>

	<%
		if (request.getMethod().equalsIgnoreCase("post")) {
			HashMap<String, String> employee = new HashMap<String, String>();
			employee.put("name", request.getParameter("name"));
			employee.put("phoneNumber", request.getParameter("contact"));
			employee.put("address", request.getParameter("address"));
			employee.put("dob", request.getParameter("dob"));
			employee.put("joiningDate", request.getParameter("doj"));
			employee.put("deptId", request.getParameter("deptId"));
			employee.put("roleId", request.getParameter("roleId"));
			employee.put("projectId", request.getParameter("projectId"));

			employeeService.addEmployee(employee);
		}
	%>
</body>
</html>