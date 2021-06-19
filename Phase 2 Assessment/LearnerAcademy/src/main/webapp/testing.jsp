<%@page import="java.util.List"%>
<%@page import="com.Models.Student"%>
<%@page import="com.Services.StudentServices"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% List<Student>stl = StudentServices.findAll(); %>
	<% for (Student s:stl){
		out.println(s.getFullName());
		out.println(s.getDateOfBirth());
	}
		
		%>
</body>
</html>