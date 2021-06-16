<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.model.FlightAvailabilityByDate"%>
<%@page import="com.model.SearchFlightDetailPojo"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight Availability Search Result</title>
<link rel="stylesheet" href="mystyle.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

	<%
	List<FlightAvailabilityByDate> availableFlightList = (ArrayList) session.getAttribute("availableFlightList");
	SearchFlightDetailPojo searchFlightDtl = (SearchFlightDetailPojo) session.getAttribute("searchFlt");
	//System.out.println(availableFlightList.size());
	
	%>

	<%@include file="SearchForm.jsp"%>
	<br>
	<br>
	<% if(availableFlightList.size() > 0) {%>
	INSIDE
	<form method="post" action="">
		<table class="center">
			<thead>
				<tr>
					<td>Flight No</td>
					<td>Source</td>
					<td>Destination</td>
					<td>TravelDate</td>
					<td>Tickets Available</td>
				</tr>
			</thead>
			<tbody>
		
				<c:forEach var="flightIt" items="${availableFlightList}" varStatus="isloop">
					<tr>
					
		
						<td><c:out value="${flightIt.flightdetail.flightId}"></c:out></td>
						<td><c:out value="${flightIt.flightdetail.tripSrcDest.sourceCityName}"></c:out></td>
						<td><c:out value="${flightIt.flightdetail.tripSrcDest.destCityName }"></c:out></td>
						<td><c:out value="${flightIt.travelDate}"></c:out></td>
						<td><c:out value="${flightIt.noOfTickets}"></c:out></td>
						<td><a href="flightTicketSchedule/bookFlightTicket?flightNo=${flightIt.flightdetail.flightId}&travelDate=${flightIt.travelDate}"><i class="fa fa-ticket" style="font-size:24px">Book Ticket</i></a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>

	</form>
	<%} else{ %>
<h2> No Flights Available for the search given.</h2>
<%} %>


</body>
</html>