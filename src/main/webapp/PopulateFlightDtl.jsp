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
<script  language = "Javascript">
			function CheckDate() {
				
				var populateStartDate = document.getElementById("populateStartDate").value;
				
				var ToDate = new Date();
				var populateStartDt = new Date(populateStartDate);
				
				if (populateStartDt.setHours(0, 0, 0, 0) < ToDate.setHours(0, 0, 0, 0)) {
					alert("The Date must be Greater than (or) Equal to today date");
					document.getElementById("populateStartDate").value = ToDate;
					return false;
				}
				return true;
			}
	function validateCount() {
				
				var dayCount = document.getElementById("DayCount").value;
				
			
				
				if (dayCount > 31 || DayCount < 0) {
					alert("Maximum of 30 Days only allowed and no negative numbers allowed");
					document.getElementById("DayCount").value = 0;
					return false;
				}
				return true;
			}
		</script>

	<br>
	<%@include file="subMenu.jsp"%>
	<br>

<div class="container col-md-8 col-md-offset-3" style="overflow: auto">
<form action="flightSchedule/populateFlightDtl" method="post" onsubmit="return validateCount()">
<h3>Flight Detail Population by date</h3>
<div class="form-group">
				<label for="DayCount">Enter No. Of Days:</label> 
				<input type="text" class="form-control" id="DayCount"  name="DayCount"  required>
			</div>
			<div class="form-group">
				<label for="populateStartDate">Enter Start Date</label> 
				<input type="date" class="form-control" id="populateStartDate" placeholder="Date" onchange="CheckDate()" name="populateStartDate" required>
			</div>
			<button type="submit" class="btn btn-secondary">Populate FlightDetails</button>

</form>
</div>
</body>
</html>