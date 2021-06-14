<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Populate Flight Detail</title>
</head>
<body>
<form action="flightDetail/populateFlightDtl" method="post">
<h3>Flight Detail Population by date</h3>

Enter No. Of Days <input type="text" id="DayCount" name="DayCount">
<br>
Enter Start Date <input type="date" id="populateStartDate" name="populateStartDate">
<br>
<input type="submit" value="Populate FlightDetails">




</form>
</body>
</html>