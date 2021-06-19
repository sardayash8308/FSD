<%@page import="com.Models.Teacher"%>
<%@page import="java.util.List"%>
<%@page import="com.Services.TeacherService"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-color: #aaa;
	border-spacing: 0;
	margin-left: auto;
	margin-right: auto;
}

.tg td {
	background-color: #fff;
	border-color: #aaa;
	border-style: solid;
	border-width: 1px;
	color: #333;
	font-family: Arial, sans-serif;
	font-size: 14px;
	overflow: hidden;
	padding: 10px 5px;
	word-break: normal;
}

.tg th {
	background-color: #ADD8E6;
	border-color: #aaa;
	border-style: solid;
	border-width: 1px;
	color: black;
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	overflow: hidden;
	padding: 10px 5px;
	word-break: normal;
	min-width: 250px;
}

.tg .tg-general {
	text-align: center;
	vertical-align: top
}

.previous {
	border: 1px solid #000;
	margin: 10px;
	background-color: #8fbc8f;
	color: black;
	border-radius: 5%;
	text-decoration: none;
	display: inline-block;
	padding: 8px 16px;
}
</style>
<meta charset="ISO-8859-1">
<title>Teacher List</title>
</head>
<body>
	<div style="text-align: center">

		<%List<Teacher> tl = TeacherService.getTeacher();%>
		<%request.setAttribute("tl", tl);%>
		<h1>Teacher List</h1><br>
		<table class="tg">
			<thead>
				<tr>
					<th class=tg-general>Teacher Name</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${tl}" var="t">
					<tr>
						<td class="tg-general">"${t.teacherName}"</td>
					</tr>
				</c:forEach>


			</tbody>
		</table>
	</div>

</body>
</html>