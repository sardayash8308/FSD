<%@page import="com.Models.Teacher"%>
<%@page import="com.Models.Class"%>
<%@page import="java.util.List"%>
<%@page import="com.Services.TeacherService"%>
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
<title>Register Subject</title>
</head>
<body>
	<div style="text-align: left">
		<h1>Add New Subject</h1>
		<hr style="clear:both;"/><br>
		 
		<% List<Class> classList = ClassService.getClasses();
		   request.setAttribute("classList", classList);
		   
		   List<Teacher> teacherList = TeacherService.getTeacher();
		   request.setAttribute("teacherList", teacherList);
		%>
				
		<form action="subjectRegistration" method="post">
			<label for="subject_name">Name:</label>
			<input type="text" id="subject_name" name="subject_name">
			<br><br>
			
			<label for="classId">Class:</label>
			<select id="classId" name="classId">
				<c:forEach items="${classList}" var="item">
				    <option value="${item.id}">${item.className}</option>
				</c:forEach>			
			</select>
			<br><br>
			<label for="teacherId">Teacher:</label>
			<select id="teacherId" name="teacherId">
				<c:forEach items="${teacherList}" var="teacher">
				    <option value="${teacher.id}">${teacher.teacherName}</option>
				</c:forEach>			
			</select>
			<br/><br/>
			<input class="register" type="submit" name="register" value="Register Subject">
			<br/>
			<a href="dashboard.jsp" class="previous">&laquo; Back to Dashboard</a>
		</form>
	</div>	
</body>
</html>