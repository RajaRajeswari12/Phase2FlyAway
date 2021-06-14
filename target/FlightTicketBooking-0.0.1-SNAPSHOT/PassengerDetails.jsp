<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List" %>
       <%@page import="java.util.ArrayList" %>
        <%@page import="com.model.PassengersDetail" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get Passenger Details</title>
<link rel="stylesheet" href="mystyle.css">
</head>
<body>
<form method="post" action="">
<table class="center">
<thead>
<tr>
<td>Serial No</td> <td>Passenger FirstName</td> <td>Passenger LastName</td><td>Age</td><td>Male/Female</td>
</tr>
</thead>
<tbody>
<% Integer noOfPassenger= (Integer)session.getAttribute("TotalPassengers"); 

for(int loop=1;loop <= noOfPassenger;loop++){
%>
<tr><td><%= loop %></td> <td><input type="text" name="fname<%=loop %>" ></td>
<td><input type="text" name="lname<%=loop %>" /></td>
<td><input type="number" name="Age<%=loop %>" /></td>
<td><select name="Gender<%=loop %>" >
<option value="Male">Male</option>
<option value="Female">Female</option>
</select></td>
<%} %>

</tbody>
</table>

<input type="submit" value="Pay Now" name="Pay">
</form>
<% if(request.getParameter("Pay") != null) {
	List<PassengersDetail> passengerList=new ArrayList();
	for(int loop=1;loop<=noOfPassenger;loop++){
		PassengersDetail ps = new PassengersDetail();
		ps.setFirstName(request.getParameter("fname"+loop));
		ps.setLastName(request.getParameter("lname"+loop));
		ps.setAge(Integer.valueOf(request.getParameter("Age"+loop)));
		ps.setGender(request.getParameter("Gender"+loop));		
		passengerList.add(ps);
		System.out.println(ps);
	}
	
	session.setAttribute("passengerList", passengerList);
	System.out.println(passengerList+"Outside Loop");
%>
<jsp:forward page="PaymentSite.jsp"></jsp:forward>
<% }%>


</body>
</html>