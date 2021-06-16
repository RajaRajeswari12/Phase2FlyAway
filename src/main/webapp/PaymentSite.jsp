<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Site</title>
<link rel="stylesheet" href="mystyle.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<br>
	<div class="form-group">
		<p>
		<h3>
			<center>Kindly Enter the Card Details</center>
		</h3>
		</p>
		<br>
		<form method="post" action="flightTicketSchedule/bookTicket">
			<h3>
				<center>Payment Site</center>
			</h3>
			<table class="center">
				<thead>
					<tr>
						<td></td>
						<td><Bold>
							<h2>Credit Card details</h2>
							</Bold></td>
						<td></td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input type="number" min="1000" max="9999"
							required="required"></td>
						<td><input type="number" min="1000" max="9999"
							required="required"></td>
						<td><input type="number" min="1000" max="9999"
							required="required"></td>
					</tr>
					<tr>
						<td><h3>
								<Bold>cvv</Bold>
							</h3></td>
						<td><input type="number" min="100" max="999"
							required="required"></td>
					</tr>
					<tr>
						<td><h3>
								<Bold>Expiry date</Bold>
							</h3></td>
						<td><input type="number" min="00" max="99"
							required="required"></td>
						<td><input type="number" min="00" max="99"
							required="required"></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td>

							<button style="font-size: 24px" type="submit" name="PayNow"
								class="btn btn-dark">
								<i class="fa fa-cc-paypal"
									style="font-size: 29px; color: #86b300"></i> PayNow
							</button>
						</td>
					</tr>
				</tbody>
			</table>

		</form>
	</div>
</body>
</html>