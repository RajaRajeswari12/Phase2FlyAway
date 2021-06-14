<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Airline</title>
<link rel="stylesheet" href="mystyle.css">
</head>
<body>
<br>
<%@include file="Header.jsp" %>
<br>

<form action="setBeanProperty.jsp" method="post">
<h3><center> New Airline Registration </center></h3>

<Table class="center">
<thead>
<tr> <th>Details To Be Entered</th> <th> Enter New Airline Details </th>
</thead>
<tbody>
<tr><td> Enter Airline Name </td> <td> <input type="text" name="airLineName"></td></tr>
</tbody>
<tr><td></td><td><input type="submit" value="Register Airline" name="registerAirline"></td></tr>
</Table>
</form>
</body>
<% if(request.getParameter("registerAirline")!=null) 
{	%>
<jsp:useBean id="newAirline" class="com.model.Airline" scope="session"></jsp:useBean>
	<jsp:setProperty property="*" name="newAirline"/>
	<jsp:forward page="Airline/addAirline"></jsp:forward>

<%  

}
%>
</html>