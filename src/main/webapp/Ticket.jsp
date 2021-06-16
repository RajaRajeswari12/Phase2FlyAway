<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.model.FlightTicket"%>
<%@page import="com.model.PassengersDetail"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>\
<link rel="stylesheet" href="mystyle.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<%
	FlightTicket choosenFlight = (FlightTicket) session.getAttribute("flightTicket");

	if (request.getParameter("getTicket") == null) {
	%>
	<br>
	<h3>
		<center>Your Ticket has been booked successfully. And your
			ticket details are given below</center>
	</h3>
	<%
	}else {%>
	<br>
	<h3>
		<center>Your ticket details are given below</center>
	</h3>
	<%}
	if (choosenFlight != null) {
	%>
	<br>
	<form>

		<table class="center">
			<thead>

			</thead>
			<tbody>
				<tr>
					<td><h4>Ticket No</h4></td>
					<td><%=choosenFlight.getTicketId()%></td>
				</tr>
				<tr>
					<td><h4>Flight No</h4></td>
					<td><%=choosenFlight.getFlightNo()%></td>
				</tr>
				<tr>
					<td><h4>Source City</h4`></td>
					<td><%=choosenFlight.getSourceCity()%></td>
				</tr>
				<tr>
					<td><h4>Destination</h4></td>
					<td><%=choosenFlight.getDestinationCity()%></td>
				</tr>
				<tr>
					<td><h4>Departure Time</h4></td>
					<td><%=choosenFlight.getDepartureTime()%></td>
				</tr>


				<tr>
					<td><h4>No Of Passengers</h4></td>
					<td><%=choosenFlight.getNoOfPassenger()%></td>
				</tr>
				<tr>
					<td><h4>Passenger Details</h4></td>
					<td>
					<table>
					<thead>
					<tr><td>Passenger No </td> <td>PassengerName</td> <td>Passenger Age</td> <td>Passenger Gender</td></tr>
					</thead>
					<tbody>
					<% 
					List<PassengersDetail> passengerList = choosenFlight.getPassengerList();
					for(int index=0;index < passengerList.size(); index++ ) {
						PassengersDetail ps = passengerList.get(index);
						%>
					<tr>
					<td><%=index+1 %> : </td><td><%=ps.getFirstName()+" "+ps.getLastName() %></td>
					<td><%=ps.getAge() %></td><td><%= ps.getGender()%></td>
					</tr>
					<%} %>
					</tbody>
					</table>					
					</td>
				</tr>
				<tr>
					<td><h4>Total Fare</h4></td>
					<td>Rs <%=choosenFlight.getTotalFare()%></td>
				</tr>
				<tr>
					<td><h4>Travel Date</h4></td>
					<td><%=choosenFlight.getTravelDate()%></td>
				</tr>
			</tbody>
		</table>
	</form>
	<%
				} else {
				%>
	<br>
	<br>
	<h2>
		<center>Kindly Enter Correct Ticket No.</center>
	</h2>
	<%
				}
				%>

</body>
</html>