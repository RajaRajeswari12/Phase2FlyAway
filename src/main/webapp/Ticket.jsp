<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.model.FlightTicket" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>\
<link rel="stylesheet" href="mystyle.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<%@include file="Header.jsp"%>
<% FlightTicket choosenFlight = (FlightTicket) session.getAttribute("flightTicket"); %>
<h4>Your Ticket has been booked successfully. And your ticket details are given below</h4>
<form>

		<table class="center">
			<thead>

			</thead>
			<tbody>
				<tr>
					<td>Ticket No</td>
					<td><%=choosenFlight.getTicketId()%></td>
				</tr>
				<tr>
					<td>Flight No</td>
					<td><%=choosenFlight.getFlightNo()%></td>
				</tr>
				<tr>
					<td>Source City</td>
					<td><%=choosenFlight.getSourceCity()%></td>
				</tr>
				<tr>
					<td>Destination</td>
					<td><%=choosenFlight.getDestinationCity()%></td>
				</tr>
				<tr>
					<td>Departure Time</td>
					<td><%=choosenFlight.getDepartureTime()%></td>
				</tr>
				
			
				<tr>
					<td>No Of Passengers</td>
					<td><%=choosenFlight.getNoOfPassenger()%></td>
				</tr>
				<tr> <td>Passenger Details</td>
				<td><%=choosenFlight.getPassengerList()%></td>
			<%-- 	<c:forEach var="passenger" items="${choosenFlight.passengerList }" >
				
					<tr>
					<td><c:out value="${passenger.firstName}"></c:out><c:out value="${passenger.lastName}"></c:out>
					<c:out value="${passenger.age}"></c:out>
					<c:out value="${passenger.Gender}"></c:out>
					</td>
					</tr>
				</c:forEach> --%>
				
				<tr>
					<td>Total Fare</td>
					<td>Rs <%=choosenFlight.getTotalFare()%></td>
				</tr>
				<tr>
					<td>Travel Date</td>
					<td><%=choosenFlight.getTravelDate()%></td>
				</tr>
</form>
</body>
</html>