<%@page import="com.model.FlightRunningDays"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.model.FlightDetail"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editing Flight Detail</title>
<link rel="stylesheet" href="mystyle.css">
</head>
<body>
<%@include file="AdminMenu.jsp"%>
	<br>
	<%
	FlightDetail flight = (FlightDetail) session.getAttribute("flightDtl");
	if(flight != null){
	%>
	<form method="post" action="setBeanProperty.jsp">

		<h3><center>Edit The Details of the flight</center></h3>

		<table class="center">
			<thead>
				<tr>
					<td>Flight No. <h4>[<%=flight.getFlightId() %>]</h4> Details </td>
					<td>Details To Be Edited</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Flight No</td>
					<td><input type="text" readonly="readonly"
						value="<%=flight.getFlightId()%>" name="flightId"></td>
				</tr>
				<tr>
					<td>Source City Name</td>
					<td><input type="hidden" name="tripId" value="<%= flight.getTripSrcDest().getTripId() %>">
					<input type="text"
						value="<%=flight.getTripSrcDest().getSourceCityName()%>"
						name="sourceCityName"></td>
				</tr>
				<tr>
					<td>Source Country Name</td>
					<td><input type="text"
						value="<%=flight.getTripSrcDest().getSourceCountry()%>"
						name="sourceCountry"></td>
				</tr>
				<tr>
					<td>Destination City Name</td>
					<td><input type="text"
						value="<%=flight.getTripSrcDest().getDestCityName()%>"
						name="destCityName"></td>
				</tr>
				<tr>
					<td>Destination Country</td>
					<td><input type="text"
						value="<%=flight.getTripSrcDest().getDestCountry()%>"
						name="destCountry"></td>
				</tr>
				<tr>
					<td>Airline</td>
					<td><input type="hidden" name="airlineId" value="<%=flight.getAirline().getAirlineId() %>">
					<input type="text"
						value="<%=flight.getAirline().getAirLineName()%>"
						name="airLineName"></td>

				</tr>
				<tr>
					<td>Ticket Price</td>
					<td><input type="text" value="<%=flight.getTicketPrice()%>"
						name="ticketPrice"></td>
				</tr>
				<tr>
					<td>Departure Time</td>
					<td><input type="text" value="<%=flight.getDepartureTime()%>"
						name="departureTime"></td>
				</tr>
				<tr>
					<td>Travel Duration</td>
					<td><input type="text" value="<%=flight.getTravelDuration()%>"
						name="travelDuration"></td>
				</tr>

				<tr>
					<td><label>Flight Running Days Schedule </label>&nbsp;</td>
					<td>
							 <input type="hidden" id="flightScheduleId" name="flightScheduleId" value="<%=flight.getFlightRunningDays().getFlightScheduleId() %>">
							<input type="checkbox"	id="schedule" name="runningOnMonday"value="True" <% if(flight.getFlightRunningDays().isRunningOnMonday()) { %>checked="checked" <%} %>> <label
							for="schedule"> Monday</label><br> 
							<input type="checkbox"	id="schedule" name="runningOnTuesday" value="True" <% if(flight.getFlightRunningDays().isRunningOnTuesday()) { %>checked="checked" <%} %>> <label
							for="schedule"> Tuesday</label><br> 
							<input type="checkbox"	id="schedule" name="runningOnWednesday" value="True" <% if(flight.getFlightRunningDays().isRunningOnWednesday()) { %>checked="checked" <%} %>> <label
							for="schedule"> Wednesday</label> <br>
							<input type="checkbox"	id="schedule" name="runningOnThursday" value="True" <% if(flight.getFlightRunningDays().isRunningOnThursday()) { %>checked="checked" <%} %>> <label
							for="schedule"> Thursday</label><br>   
							 <input type="checkbox"	id="schedule" name="runningOnFriday" value="True"<% if(flight.getFlightRunningDays().isRunningOnFriday()) { %>checked="checked" <%} %>> <label
							for="schedule"> Friday</label> <br>  
							<input type="checkbox"	id="schedule" name="runningOnSaturday" value="True" <% if(flight.getFlightRunningDays().isRunningOnSaturday()) { %>checked="checked" <%} %>> <label
							for="schedule"> Saturday</label><br> 
							<input type="checkbox" id="schedule" name="runningOnSunday" value="True" <% if(flight.getFlightRunningDays().isRunningOnSunday()) { %>checked="checked" <%} %>> <label
							for="schedule"> Sunday</label>
							</td>
				</tr>


				<tr>
					<td></td>
					<td><input type="submit" value="Update Detail"
						name="updateFlight"></td>
				</tr>

			</tbody>

		</table>


	</form>
<%}else{ %>
<h3> Page Details Not found. Try Again </h3>
<%} %>
</body>
</html>