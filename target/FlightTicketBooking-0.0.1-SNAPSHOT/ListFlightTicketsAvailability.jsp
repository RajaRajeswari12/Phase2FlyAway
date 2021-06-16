<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.model.FlightAvailabilityByDate"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Airline</title>
<link rel="stylesheet" href="mystyle.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

	<%@include file="AdminMenu.jsp"%>
	<br>

	<%
	List<FlightAvailabilityByDate> flightAvailabilityByDateList = (List<FlightAvailabilityByDate>) session
			.getAttribute("flightAvailabilityByDateList");
	%>
	<form method="post" action="flightSchedule/deleteFlightByTripDate">
		<h3>
			<center>Airline List</center>
		</h3>

		<button type="submit" value="Delete Selected Flight"
			name="DeleteFlightsByDate" class="btn btn-dark">
			<i class="fa fa-trash"></i> Delete Selected Flight
		</button>

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
					<td>Delete</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="flightAvailableDetail"
					items="${flightAvailabilityByDateList }">
					<tr>
						<td><input type="checkbox" id="TripScheduleId"
							name="TripScheduleId"
							value="${flightAvailableDetail.flightTripId}"> <c:out
								value="${flightAvailableDetail.flightdetail.flightId }"></c:out></td>
						<td><c:out
								value="${flightAvailableDetail.flightdetail.tripSrcDest.sourceCityName }"></c:out></td>
						<td><c:out
								value="${flightAvailableDetail.flightdetail.tripSrcDest.destCityName }"></c:out></td>
						<td><c:out
								value="${flightAvailableDetail.flightdetail.airline.airLineName }"></c:out></td>
						<td><c:out
								value="${flightAvailableDetail.flightdetail.ticketPrice }"></c:out></td>
						<td><c:out
								value="${flightAvailableDetail.flightdetail.departureTime }"></c:out></td>
						<td><c:out
								value="${flightAvailableDetail.flightdetail.travelDuration }"></c:out></td>
						<td><c:out value="${flightAvailableDetail.travelDate }"></c:out></td>
						<td><c:out value="${flightAvailableDetail.noOfTickets }"></c:out></td>
						<td><a
							href="flightSchedule/deleteFlightByTripDateById?flightTripId=${flightAvailableDetail.flightTripId }"><i
								style='font-size: 24px; color: red' class='fa fa-trash'></i>
								Delete</a></td>
					</tr>

				</c:forEach>

			</tbody>
		</table>
	</form>
	<%-- 	<%
	if (request.getParameter("DeleteFlightsByDate") != null) {
		String flightTripIds[] = request.getParameterValues("TripScheduleId");
		for (String s : flightTripIds) {
			System.out.println(s);
		}

		if (flightTripIds != null && flightTripIds.length > 0) {
			session.removeAttribute("flightAvailabilityByDateList");
			session.setAttribute("FlightTripIdList", flightTripIds);
			response.sendRedirect("/flightSchedule/deleteFlightByTripDate");
		}
	}
	%> --%>
</body>
</html>