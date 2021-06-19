<%@page import="com.Models.Class"%>
<%@page import="java.util.List"%>
<%@page import="com.Services.ClassService"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	.register {border: 1px solid #000; margin: 10px; background-color: #ADD8E6;color: black;border-radius: 5%;text-decoration: none;display: inline-block;padding: 8px 16px;}
	.previous {border: 1px solid #000; margin: 10px; background-color: #8fbc8f;color: #003300;border-radius: 5%;text-decoration: none;display: inline-block;padding: 8px 16px;}
</style>
<meta charset="ISO-8859-1">
<title>Class Report Menu</title>
</head>
<body>
	<div style="text-align: left">
		<h1>Grade Report Menu</h1>  
		<% List<Class> classList = ClassService.getClasses();
		   request.setAttribute("classList", classList);
		%>
		<hr style="clear:both;"/><br>
		<form action="classReport" method="post">
			<label for="classId">Select a grade:</label>
			<select id="classId" name="classId">
				<c:forEach items="${classList}" var="item">
				    <option value="${item.id}">${item.className}</option>
				</c:forEach>			
			</select>
			<br/><br/>
			<input class="register" type="submit" name="register" value="View Report">
		</form>
		<a href="dashboard.jsp" class="previous">&laquo; Back to Dashboard</a>
	</div>	
</body>
</html>