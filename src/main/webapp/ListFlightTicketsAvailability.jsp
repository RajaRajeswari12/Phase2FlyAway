<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.model.FlightAvailabilityByDate"%>
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
	List<FlightAvailabilityByDate> flightAvailabilityByDateList = (List<FlightAvailabilityByDate>) session.getAttribute("flightAvailabilityByDateList");
	
	//System.out.println(flightAvailabilityByDateList);
	%>
	<form method="post" action="">
		<h3>
			<center>Airline List</center>
		</h3>
		<table class="center">
			<thead>
				<tr>
					<td>Flight No</td>
					<td>Source</td>
					<td>Destination</td>
					<td>Airline</td>
					<td>Ticket Price</td>
					<td>Departure Time</td>
					<td>Travel Duration</td>
					<td>Travel Date</td>
					<td>No.Of Ticket</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="flightAvailableDetail" items="${flightAvailabilityByDateList }">
				<tr>
				<td><c:out value="${flightAvailableDetail.flightdetail.flightId }"></c:out></td>
						<td><c:out value="${flightAvailableDetail.flightdetail.tripSrcDest.sourceCityName }"></c:out></td>
						<td><c:out value="${flightAvailableDetail.flightdetail.tripSrcDest.destCityName }"></c:out></td>
						<td><c:out value="${flightAvailableDetail.flightdetail.airline.airLineName }"></c:out></td>
						<td><c:out value="${flightAvailableDetail.flightdetail.ticketPrice }"></c:out></td>
						<td><c:out value="${flightAvailableDetail.flightdetail.departureTime }"></c:out></td>
						<td><c:out value="${flightAvailableDetail.flightdetail.travelDuration }"></c:out></td>
						<td><c:out value="${flightAvailableDetail.travelDate }"></c:out></td>
						<td><c:out value="${flightAvailableDetail.noOfTickets }"></c:out></td>
				
				</tr>
				
				</c:forEach>
				
			</tbody>
		</table>
	</form>

</body>
</html>