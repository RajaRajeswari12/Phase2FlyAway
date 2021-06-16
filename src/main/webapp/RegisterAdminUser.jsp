<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register User</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<%@include file="AdminMenu.jsp"%>
	<br>
	<div class="container col-md-8 col-md-offset-3" style="overflow: auto">
		<h1>Register Form</h1>
		<form action="" method="post">
			<div class="form-group">
				<label for="firstName">First Name:</label> <input type="text"
					class="form-control" id="username" placeholder="First Name"
					name="firstName" required>
			</div>
			<div class="form-group">
				<label for="lastName">Last Name:</label> <input type="text"
					class="form-control" id="lastName" placeholder="Last Name"
					name="lastName" required>
			</div>
			<div class="form-group">
				<label for="userType">User Type:</label> <select
					class="form-control" id="userType" placeholder="user Type"
					name="userType" required>
					<option value="Admin">Admin</option>
					<option value="Guest">Guest</option>
				</select>
			</div>
			<div class="form-group">
				<label for="username">User Name:</label> <input type="text"
					class="form-control" id="username" placeholder="User Name"
					name="username" required>
			</div>
			<div class="form-group">
				<label for="password">Password:</label> <input type="password"
					class="form-control" id="password" placeholder="Password"
					name="password" required>
			</div>
			<button type="submit" class="btn btn-primary" value="RegisterUser"
				name="RegisterUser">Submit</button>
		</form>
		<hr align="center">
	</div>
	<%
	if (request.getParameter("RegisterUser") != null) {
	%>
	<jsp:useBean id="RegisterUser" class="com.model.User" scope="session"></jsp:useBean>
	<jsp:setProperty property="*" name="RegisterUser" />
	
	<jsp:forward page="UserRegisterServlet/register"></jsp:forward>

	<%} %>
</body>
</html>