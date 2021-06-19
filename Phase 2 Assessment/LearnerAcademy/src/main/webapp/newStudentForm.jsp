<%@page import="com.Models.Class"%>
<%@page import="java.util.List"%>
<%@page import="com.Services.ClassService"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.register {
	border: 1px solid #000;
	margin: 10px;
	background-color: #ADD8E6;
	color: black;
	border-radius: 5%;
	text-decoration: none;
	display: inline-block;
	padding: 8px 16px;
}

.previous {
	border: 1px solid #000;
	margin: 10px;
	background-color: #8fbc8f;
	color: #003300;
	border-radius: 5%;
	text-decoration: none;
	display: inline-block;
	padding: 8px 16px;
}
</style>
<meta charset="ISO-8859-1">
<title>Register Student</title>
</head>
<body>
	<div style="text-align: left">
		<h1>Add New Student</h1>
		<hr style="clear: both;" />
		<br>

		<%!ClassService classService = new ClassService();%>
		<%
		List<Class> classList = classService.getClasses();
		request.setAttribute("classList", classList);
		%>
		<form action="student" method="post">
			<label for="firstName">First Name:</label> <input type="text"
				id="firstName" name="firstName"> <br>
				
			<br> <label for="fatherName">Father Name:</label> <input
				type="text" id="fatherName" name="fatherName"> <br>
				
			<br> <label for="motherName">Mother Name:</label> <input
				type="text" id="motherName" name="motherName"> <br>
				
			<br> <label for="lastName">Last Name:</label> <input type="text"
				id="lastName" name="lastName"> <br>
				
			<br> <label for="city">City :</label> <input type="text"
				id="city" name="city"> 
			<br><label for="adress">Address of the Student:</label>
			<input type="text" id="adress" name="adress">
			
			<br>
			<br> <label for="dob">Date Of Birth:</label> <input type="date"
				id="dob" name="dob"> <br>
				
			<br> <label for="classId">Class:</label> <select id="classId"
				name="classId">
				<c:forEach items="${classList}" var="item">
					<option value="${item.id}">${item.className}</option>
				</c:forEach>
			</select> <br />
			<br /> <input class="register" type="submit" name="register"
				value="Register Student"> <br /> <a href="dashboard.jsp"
				class="previous">&laquo; Back to Dashboard</a>
		</form>
	</div>
</body>
</html>