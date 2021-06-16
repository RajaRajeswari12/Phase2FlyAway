
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<%
	String validLogin = (String) session.getAttribute("InvalidLogin");
	System.out.println("Valid Login" + validLogin);
	session.removeAttribute("InvalidLogin");
	%>
	<%@include file="MainMenu.jsp"%>
	<br>
	<div class="container col-md-8 col-md-offset-3" style="overflow: auto">
		<h1>
			<center>Login Form</center>
		</h1>
		<form action="UserRegisterServlet/login" method="post">
			<div class="form-group">
				<label for="uname">User Name:</label> <input type="text"
					class="form-control" id="username" placeholder="User Name"
					name="username" required>
			</div>
			<div class="form-group">
				<label for="uname">Password:</label> <input type="password"
					class="form-control" id="password" placeholder="Password"
					name="password" required>
			</div>
			<center>
				<button type="submit" class="btn btn-secondary">Submit</button>
			</center>
		</form>
	
<br>

		<%
		if (validLogin != null) {
		%>
		<div class="alert alert-info"><%=validLogin%></div>
		<%
		}
		%>
	
</body>
</html>