<%@page import="com.Models.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.Services.StudentServices"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	.tg  {border-collapse:collapse;border-color:#aaa;border-spacing:0;margin-left: auto;margin-right: auto;}
	.tg td{background-color:#fff;border-color:#aaa;border-style:solid;border-width:1px;color:#333;
	  font-family:Arial, sans-serif;font-size:14px;overflow:hidden;padding:10px 5px;word-break:normal;}
	.tg th{background-color:#ADD8E6;border-color:#aaa;border-style:solid;border-width:1px;color:black;
	  font-family:Arial, sans-serif;font-size:14px;font-weight:normal;overflow:hidden;padding:10px 5px;word-break:normal;min-width: 250px;}
	.tg .tg-general{text-align:center;vertical-align:top}
	.previous {border: 1px solid #000; margin: 10px; background-color: #8fbc8f;color: black;border-radius: 5%;text-decoration: none;display: inline-block;padding: 8px 16px;}
</style>
<meta charset="ISO-8859-1">
<title>Student List</title>
</head>
<body>
	<div style="text-align: center">
		<h1>Student List</h1>  
		<% List<Student> studentList = StudentServices.findAll();
		   request.setAttribute("studentList", studentList);
		%>
		
		<table class="tg">
		<thead>
		  <tr>
		    <th class=tg-general>First Name</th>
		    <th class=tg-general>Father Name</th>
		    <th class=tg-general>Mother Name</th>
		    <th class="tg-general">Last Name</th>
		    <th class="tg-general">Date of Birth</th>
		    <th class="tg-general">Class</th>
		  </tr>
		</thead>
		<tbody>
			<c:forEach items="${studentList}" var="student">
				<tr>
					<td class="tg-general">${student.firstName}</td>
					<td class="tg-general">${student.fatherName}</td>
					<td class="tg-general">${student.motherName}</td>
				    <td class="tg-general">${student.lastName}</td>
				    <td class="tg-general">${student.dateOfBirth}</td>
				    <td class="tg-general">${student.cls.className}</td>
				</tr>
			</c:forEach>
		</tbody>
		</table>
		<a href="dashboard.jsp" class="previous">&laquo; Back to Dashboard</a>
	</div>
</body>
</html>