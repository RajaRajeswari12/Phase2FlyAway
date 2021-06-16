	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	
	
	<%
	HttpSession Session = request.getSession(false);
	String userType = (String) session.getAttribute("userType");
	if ( userType == null || !userType.equals("Admin")) {
		response.sendRedirect("AdminLogin.jsp");
	}
	%>


	<header class="p-3 bg-dark text-white">
		<div class="container">
			<div
				class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
				<ul
					class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
					<li><a href="flightDetail/listFlight" class="nav-link px-2 text-white">[List Flight Details]</a></li>
					<li><a href="RegisterFlight.jsp" class="nav-link px-2 text-white">[Add New Flight Details]</a></li>
					<li><a href="PopulateFlightDtl.jsp" class="nav-link px-2 text-white">[Populate FlightDetails by Date]</a></li>
					<li><a href="flightSchedule/listFlightDtlByDate" class="nav-link px-2 text-white">[List Flight Availability by Date]</a></li>
				</ul>
				<div class="text-end">
					<a href="<%=request.getContextPath() %>/UserRegisterServlet/logout"  class="btn btn-outline-light me-2">Logout</a>
				</div>
			</div>
		</div>
	</header>
</body>
</html>

