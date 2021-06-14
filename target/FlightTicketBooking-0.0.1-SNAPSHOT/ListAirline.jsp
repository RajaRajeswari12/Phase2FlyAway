<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.model.Airline"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Airline</title>
<link rel="stylesheet" href="mystyle.css">
</head>
<body>

	<br>
	<%@include file="Header.jsp"%>

	<br>
	<br>
	<%@include file="subMenu.jsp"%>
	<br>

	<%
	List<Airline> airLineList = (ArrayList) session.getAttribute("airlineList");
	%>
	<form method="post" action="">
		<h3>
			<center>Airline List</center>
		</h3>
		<table class="center">
			<thead>
				<tr>
					<td>Airline Id</td>
					<td>Airline Name</td>
				</tr>
			</thead>
			<tbody>
				<c:foreach var="airline" items="${airLineList }">
				<tr>
				<td><c:out value="${airline.airlineId }"></c:out></td>
				
				<td><c:out value="${airline.airLineName }"></c:out></td>
				<td> <a href="Airline/editAirline?airlineId=${airline.airlineId}"><i style='font-size:24px;color:red' class='fas'>&#xf044;</i> 
						 Edit</a></td>
				<td> <a href="Airline/deleteAirline?airlineId=${airline.airlineId}"><i style='font-size:24px;color:red' class='fas'>&#xf044;</i> 
						 Delete</a></td>
				</tr>
				
				</c:foreach>
				
			</tbody>
		</table>
	</form>

</body>
</html>