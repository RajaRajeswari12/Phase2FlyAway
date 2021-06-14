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
	<form method="post" action="flightSchedule/bookTicket">
		<h3>
			<center>Payment Site</center>
		</h3>
		<table>
			<thead>
				<tr>
					<td></td>
					<td>Credit Card details</td>
					<td></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="number" maxlength="4"></td>
					<td><input type="number" maxlength="4"></td>
					<td><input type="number" maxlength="4" ></td>
				</tr>
				<tr>
				<td>cvv </td>
				<td><input type="text" maxlength="3"></td>
				</tr>
				<tr>
				<td>Expiry date </td>
				<td><input type="number" maxlength="2"></td>
				<td><input type="number" maxlength="2"></td>
				</tr>
				<tr>
				<td> </td>
				<td></td>
				<td><input type="submit" value="PayNow"></td>
				</tr>
			</tbody>
		</table>

	</form>
</body>
</html>