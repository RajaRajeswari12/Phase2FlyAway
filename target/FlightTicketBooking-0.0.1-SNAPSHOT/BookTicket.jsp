<%@page import="com.model.FlightTicket"%>
<%@page import="com.model.SearchFlightDetailPojo"%>
<%@page import="com.model.FlightAvailabilityByDate"%>
<%@page import="java.time.LocalTime"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight Detail Confirmation</title>
<link rel="stylesheet" href="mystyle.css">
</head>
<body>
<%@include file="Header.jsp"%>
	<%
	FlightAvailabilityByDate choosenFlight = (FlightAvailabilityByDate) session.getAttribute("ChosenFlightDetail");
	LocalTime departTime = choosenFlight.getFlightdetail().getDepartureTime();
	LocalTime duration = choosenFlight.getFlightdetail().getTravelDuration();
	LocalTime total = departTime.plusHours(duration.getHour()).plusMinutes(duration.getMinute());
	SearchFlightDetailPojo searchFlightDtl = (SearchFlightDetailPojo) session.getAttribute("searchFlt");
	Double ticketPrice = choosenFlight.getFlightdetail().getTicketPrice();
	Integer noOfPassengers = searchFlightDtl.getNoOfPassengers();
	
	
	
	FlightTicket ft = new FlightTicket();
	ft.setFlightNo(choosenFlight.getFlightdetail().getFlightId());
	ft.setSourceCity(choosenFlight.getFlightdetail().getTripSrcDest().getSourceCityName());
	ft.setDestinationCity(choosenFlight.getFlightdetail().getTripSrcDest().getDestCityName());
	ft.setNoOfPassenger(noOfPassengers);
	ft.setTravelDate(choosenFlight.getTravelDate());
	ft.setDepartureTime(departTime);
	ft.setTotalFare(ticketPrice*noOfPassengers);
	ft.setUserName((String)session.getAttribute("userName"));
	session.setAttribute("flightTicket", ft);
	%>
	<p> <center> Kindly confirm your Ticket Booking Details mentioned below</center></p>
	

	<form method="post" action="PassengerDetails.jsp">
		<table class="center">
			<thead>

			</thead>
			<tbody>
				<tr>
					<td>Flight No</td>
					<td><%=choosenFlight.getFlightdetail().getFlightId()%></td>
				</tr>
				<tr>
					<td>Source City</td>
					<td><%=choosenFlight.getFlightdetail().getTripSrcDest().getSourceCityName()%></td>
				</tr>
				<tr>
					<td>Destination</td>
					<td><%=choosenFlight.getFlightdetail().getTripSrcDest().getDestCityName()%></td>
				</tr>
				<tr>
					<td>Departure Time</td>
					<td><%=choosenFlight.getFlightdetail().getDepartureTime()%></td>
				</tr>
				<tr>
					<td>Travel Duration</td>
					<td><%=choosenFlight.getFlightdetail().getTravelDuration()%></td>
				</tr>
				<tr>
					<td>Arrival Time</td>
					<td><%=total%></td>
				</tr>
				<tr>
					<td>No Of Passengers</td>
					<td><%=noOfPassengers%></td>
				</tr>
				<tr>
					<td>TicketFare per Passenger</td>
					<td>Rs <%=ticketPrice%></td>
				</tr>
				<tr>
					<td>Total Fare</td>
					<td>Rs <%=noOfPassengers * ticketPrice%></td>
				</tr>
				<tr>
					<td>Travel Date</td>
					<td><%=choosenFlight.getTravelDate()%></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Confirm Booking" name="book"
						onclick=<c:set var="TotalPassengers" value="<%=noOfPassengers %>" scope="session"></c:set>></td>
				</tr>

			</tbody>
		</table>


	</form>
	
	
</body>
</html>

<%--  --%>