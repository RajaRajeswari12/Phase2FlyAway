<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.model.PassengersDetail"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get Passenger Details</title>
<link rel="stylesheet" href="mystyle.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<br>
	<%Integer noOfPassenger = (Integer) session.getAttribute("TotalPassengers");
	if(noOfPassenger != null){
	%>
	<form method="post" action="">

		<div class="form-group">
		<p> <h3 class="center"> Kindly Enter the Details of the Passenger </h3></p>
			<table class="table-secondary">
				<thead>
					<tr>
						<td>Serial No</td>
						<td>Passenger FirstName</td>
						<td>Passenger LastName</td>
						<td>Age</td>
						<td>Male/Female</td>
					</tr>
				</thead>
				<tbody>
					<%
					

					for (int loop = 1; loop <= noOfPassenger; loop++) {
					%>
					<tr>
						<td><%=loop%></td>
						<td><input type="text" name="fname<%=loop%>"></td>
						<td><input type="text" name="lname<%=loop%>" /></td>
						<td><input type="number" name="Age<%=loop%>" /></td>
						<td><select name="Gender<%=loop%>">
								<option value="Male">Male</option>
								<option value="Female">Female</option>
						</select></td>
						<%
						}
						%>
					<tr><td></td><td></td><td></td><td></td><td><Button type="submit" class="btn btn-secondary" value="Pay Now" name="Pay"><i class="fa fa-plane"></i>PayNow</Button></td></tr>
				</tbody>
			</table>

			
				</div>
	</form>

	<%
	if (request.getParameter("Pay") != null) {
		List<PassengersDetail> passengerList = new ArrayList();
		for (int loop = 1; loop <= noOfPassenger; loop++) {
			PassengersDetail ps = new PassengersDetail();
			ps.setFirstName(request.getParameter("fname" + loop));
			ps.setLastName(request.getParameter("lname" + loop));
			ps.setAge(Integer.valueOf(request.getParameter("Age" + loop)));
			ps.setGender(request.getParameter("Gender" + loop));
			passengerList.add(ps);
		}

		session.setAttribute("passengerList", passengerList);

	%>
	<jsp:forward page="PaymentSite.jsp"></jsp:forward>
	<%
	}
	}else {
	%>
<h3> Page Details Not found. Try Again </h3>
<%} %>

</body>
</html>