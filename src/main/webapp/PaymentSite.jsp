<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Site</title>
	<link rel="stylesheet" href="mystyle.css">
</head>
<body>
<%@include file="Header.jsp"%>
	<br>
	<div class="form-group">
		<p> <h3 class="center"> Kindly Enter the Details of the Passenger </h3></p>
	<form method="post" action="flightTicketSchedule/bookTicket">
		<h3>
			<center>Payment Site</center>
		</h3>
		<table class="table">
			<thead>
				<tr>
					<td></td>
					<td><Bold>Credit Card details</Bold></td>
					<td></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="number" maxlength="4" required="required"></td>
					<td><input type="number" maxlength="4" required="required"></td>
					<td><input type="number" maxlength="4" required="required"></td>
				</tr>
				<tr>
				<td>cvv </td>
				<td><input type="text" maxlength="3" required="required"></td>
				</tr>
				<tr>
				<td>Expiry date </td>
				<td><input type="number" maxlength="2" required="required"></td>
				<td><input type="number" maxlength="2" required="required"></td>
				</tr>
				<tr>
				<td> </td>
				<td></td>
				<td><input type="submit" value="PayNow"></td>
				</tr>
			</tbody>
		</table>

	</form>
	</div>
</body>
</html>