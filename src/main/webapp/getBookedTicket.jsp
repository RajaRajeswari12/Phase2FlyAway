<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="Header.jsp"%>
<form action="flightTicketSchedule/bookedTicketList" method="post">

<div class="container col-md-8 col-md-offset-3" style="overflow: auto">
		<h1>Get Ticket Details</h1>
		<form action="UserRegisterServlet/login" method="post">
			<div class="form-group">
				<label for="TicketNo">Enter Ticket No :</label> 
				<input type="number" class="form-control" id="TicketNo" name="TicketNo" required>
			</div>
			<button type="submit" class="btn btn-primary">Get Ticket</button>
		</form>

</div>
</form>
</body>
</html>