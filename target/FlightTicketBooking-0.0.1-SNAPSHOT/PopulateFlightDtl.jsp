<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Populate Flight Detail</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>


	<br>
	<%@include file="subMenu.jsp"%>
	<br>
<div class="container col-md-8 col-md-offset-3" style="overflow: auto">
<form action="flightSchedule/populateFlightDtl" method="post">
<h3>Flight Detail Population by date</h3>
<div class="form-group">
				<label for="DayCount">Enter No. Of Days:</label> 
				<input type="text" class="form-control" id="DayCount"  name="DayCount" required>
			</div>
			<div class="form-group">
				<label for="populateStartDate">Enter Start Date</label> 
				<input type="date" class="form-control" id="populateStartDate" placeholder="Date" name="populateStartDate" required>
			</div>
			<button type="submit" class="btn btn-secondary">Populate FlightDetails</button>

</form>
</div>
</body>
</html>