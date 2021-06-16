<%@page import="java.util.Locale"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.format.*"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.ZoneId"%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.model.TripSourceDestination"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Ticket</title>
<link rel="stylesheet" href="mystyle.css">
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<br>
	<form method="post" action="">
		<script  language = "Javascript">
			function CheckDate() {				
				var TravelDate = document.getElementById("travelDate").value;				
				var ToDate = new Date();
				var travelDt = new Date(TravelDate);
				
				if (travelDt.setHours(0, 0, 0, 0) < ToDate.setHours(0, 0, 0, 0)) {
					alert("The Date must be Greater than (or) Equal to today date");
					document.getElementById("travelDate").value = ToDate;
					return false;
				}
				return true;
			}
		</script>

		<%
		List<String> destinationList = (ArrayList) session.getAttribute("destinationList");
		List<String> srcList = (ArrayList) session.getAttribute("srcList");
		%>
		<br>
		<h3>
			<center>Search For Flight Tickets</center>
		</h3>
		<br>
		<table class="center">
			<thead>
				<tr>
					<td>Source</td>
					<td>Destination</td>
					<td>TravelDate</td>
					<td><label for="NoOfPassengers">Choose No.Of
							Passengers:</label></td>
				</tr>
			</thead>

			<tbody>
				<tr>

					<td><select id="sourceCityName" name="sourceCityName">
							<c:forEach var="src" items="${srcList}">
								<option value="${src}">${src}</option>
							</c:forEach>
					</select></td>
					<td><select id="destinationCityName"
						name="destinationCityName">
							<c:forEach var="dest" items="${destinationList}">
								<option value="${dest}">${dest}</option>
							</c:forEach>
					</select></td>
					<td><input type="date" id="travelDate" name="travelDate"
						onchange="CheckDate()" required></td>
					<td><select id="noOfPassengers" name="noOfPassengers">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
					</select>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td><input type="submit" value="Search Flight"
						name="searchFlight"></td>
				</tr>
			</tbody>
		</table>

	</form>

	<%
	if (request.getParameter("searchFlight") != null) {
		String travelDate = request.getParameter("travelDate");
		LocalDate localDate = LocalDate.parse(travelDate);
	%>

	<jsp:useBean id="searchFlt" class="com.model.SearchFlightDetailPojo"
		scope="session"></jsp:useBean>
	<jsp:setProperty property="travelDate" name="searchFlt"
		value="<%=localDate%>" />
	<jsp:setProperty property="sourceCityName" name="searchFlt"
		param="sourceCityName" />
	<jsp:setProperty property="destinationCityName" name="searchFlt"
		param="destinationCityName" />
	<jsp:setProperty property="noOfPassengers" name="searchFlt"
		param="noOfPassengers" />
	<jsp:forward page="flightTicketSchedule/searchFlight"></jsp:forward>
	<%
	}
	%>
</body>
</html>