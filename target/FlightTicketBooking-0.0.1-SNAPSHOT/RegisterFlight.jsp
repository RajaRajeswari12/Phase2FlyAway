<%@page import="java.time.LocalTime"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date" %>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight Detail Registration</title>
<link rel="stylesheet" href="mystyle.css">
</head>
<body>
<br>
<%@include file="subMenu.jsp" %>
<br>
<br>


<form action="setBeanProperty.jsp" method="post">
<h3><center> New Flight Detail Registration </center></h3>

<Table class="center">
<thead>
<tr> <th>Details To Be Entered</th> <th> Enter New Flight Details </th>
</thead>
<tbody>
<!-- Trip Source Destination Detail -->

<tr><td> Enter Source City Name </td> <td> <input type="text" name="sourceCityName"></td></tr>
<tr><td> Enter Source Country Name </td> <td> <input type="text" name="sourceCountry"></td></tr>
<tr><td> Enter Destination City Name </td> <td> <input type="text" name="destCityName"></td></tr>
<tr><td> Enter Destination Country Name </td> <td> <input type="text" name="destCountry"></td></tr>

<!-- Airline Name -->

<tr><td> Enter Airline Name </td> <td> <input type="text" name="airLineName"></td></tr>

<!-- Other Flight Details -->

<tr><td> Enter Trip Ticket Price </td> <td> <input type="number" name="ticketPrice"></td></tr>
<tr><td> Enter Flight Departure Time </td> <td> <input type="time" name="departureTime"></td></tr>
<tr><td> Enter Flight Travel Duration </td> <td> <input type="time" name="travelDuration"></td></tr>

<!-- Flight Running Days Schedule -->
<tr>
<td><label>Flight Running Days Schedule </label>&nbsp;</td>
      <td>
      <input type="checkbox" id="schedule" name="runningOnSunday" value="True">
  <label for="schedule"> Sunday</label><br>
  <input type="checkbox" id="schedule" name="runningOnMonday" value="True">
  <label for="schedule"> Monday</label><br>
  <input type="checkbox" id="schedule" name="runningOnTuesday" value="True">
  <label for="schedule"> Tuesday</label><br>
  <input type="checkbox" id="schedule" name="runningOnWednesday" value="True">
  <label for="schedule"> Wednesday</label><br>
  <input type="checkbox" id="schedule" name="runningOnThursday" value="True">
  <label for="schedule"> Thursday</label><br>
  <input type="checkbox" id="schedule" name="runningOnFriday" value="True">
  <label for="schedule"> Friday</label><br>
    <input type="checkbox" id="schedule" name="runningOnSaturday" value="True">
  <label for="schedule"> Saturday</label><br>
      
      </td>
</tr>
<tr><td></td><td><input type="submit" value="Register" name="registerFlight"></td></tr>
</tbody>



</Table>



</form>





</body>
</html>