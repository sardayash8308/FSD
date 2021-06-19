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
<title>Register Teacher</title>
</head>
<body>
	<div style="text-align: left">
		<h1>Add New Teacher</h1>
		<hr style="clear:both;"/><br>
		<form action="teacherRegistration" method="post">
			<label for="teacherName">Full Name of Teacher:</label>
			<input type="text" id="teacherName" name="teacherName">
			<br><br>
			<br/><br/>
			<input class="register" type="submit" name="register" value="Register Teacher">
			<br/>
			<a href="dashboard.jsp" class="previous">&laquo; Back to Dashboard</a>
		</form>
		<a href="teachersList.jsp" class="previous"> View Teacher List</a>
	</div>	
</body>
</html>