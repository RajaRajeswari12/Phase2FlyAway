<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List"%>
<%@page import="com.model.FlightDetail"%>
<%@page import="com.model.FlightRunningDays"%>
<%@page import="java.util.ArrayList"%>
<script src='https://kit.fontawesome.com/a076d05399.js'></script>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Retrieve Flight Detail</title>
<link rel="stylesheet" href="mystyle.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>



	<%@include file="subMenu.jsp"%>
	<br>

	<%
	List<FlightDetail> flightList = (ArrayList) session.getAttribute("flightList");
/* 
	List<FlightRunningDays> flightRunningDays = (ArrayList) session.getAttribute("flightRunningDays"); */
	

	%>
	<form method="post" action="">
		<h3>
			<center>Flight List</center>
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
						<td><label>Flight Running Days Schedule </label>&nbsp;</td>
					<td>Edit</td>
					<td>Delete</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="flight" items="${flightList}">
				
					<tr>
						<td><input type="checkbox" id="flightID" name="flightID"
							value="${flight.flightId }"> <c:out
								value="${flight.flightId }"></c:out></td>
						<td><c:out value="${flight.tripSrcDest.sourceCityName }"></c:out></td>
						<td><c:out value="${flight.tripSrcDest.destCityName }"></c:out></td>
						<td><c:out value="${flight.airline.airLineName }"></c:out></td>
						<td><c:out value="${flight.ticketPrice }"></c:out></td>
						<td><c:out value="${flight.departureTime }"></c:out></td>
						<td><c:out value="${flight.travelDuration }"></c:out></td>
												
					
						<td><input type="checkbox" id="schedule"
							name="runningOnSunday" value="True" <c:if test="${flight.flightRunningDays.runningOnSunday}" >checked="checked"</c:if> > <label
							for="schedule"> Sunday</label>  <input type="checkbox"
							id="schedule" name="runningOnMonday"value="True" <c:if test="${flight.flightRunningDays.runningOnMonday}" >checked="checked"</c:if>> <label
							for="schedule"> Monday</label> <input type="checkbox"
							id="schedule" name="runningOnTuesday" value="True" <c:if test="${flight.flightRunningDays.runningOnTuesday}" >checked="checked"</c:if>> <label
							for="schedule"> Tuesday</label><br> <input type="checkbox"
							id="schedule" name="runningOnWednesday" value="True" <c:if test="${flight.flightRunningDays.runningOnWednesday}" >checked="checked"</c:if>> <label
							for="schedule"> Wednesday</label> <input type="checkbox"
							id="schedule" name="runningOnThursday" value="True" <c:if test="${flight.flightRunningDays.runningOnThursday}" >checked="checked"</c:if>> <label
							for="schedule"> Thursday</label>   <input type="checkbox"
							id="schedule" name="runningOnFriday" value="True" <c:if test="${flight.flightRunningDays.runningOnFriday}" >checked="checked"</c:if>> <label
							for="schedule"> Friday</label> <br>  <input type="checkbox"
							id="schedule" name="runningOnSaturday" value="True" <c:if test="${flight.flightRunningDays.runningOnSaturday}" >checked="checked"</c:if>> <label
							for="schedule"> Saturday</label></td>
							<%-- <c:remove var="flightSchedule"/>
							</c:when>
							</c:choose>
						</c:forEach> --%>
						<td><a href="flightDetail/editFlight?flight=${flight.flightId}"><i
								style='font-size: 24px; color: red' class='fas'>&#xf044;</i>
								Edit</a></td>
									<td><a href="flightDetail/deleteFlightById?flightId=${flight.flightId}"><i
								style='font-size: 24px; color: red' class='fa fa-trash'></i>
								Delete</a></td>
					</tr>
				</c:forEach>
				<tr><td><button type="submit" value="Delete Selected Flight" name="DeleteFlights" class="btn btn-dark"><i class="fa fa-trash"></i> Delete Selected Flight</button>
				</td></tr>
			</tbody>

		</table>
		
	</form>

	<%
	if (request.getParameter("DeleteFlights") != null) {
		String flightIds[] = request.getParameterValues("flightID");
		System.out.println("flightIds "+flightIds);
		if(flightIds != null && flightIds.length > 0){
			session.removeAttribute("flightList");
		session.setAttribute("FlightIdList", flightIds);
	%>
	<jsp:forward page="flightDetail/deleteFlight"></jsp:forward>
	<%
	}
	}
	%>

</body>
</html>