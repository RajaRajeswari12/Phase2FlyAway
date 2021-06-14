<%@page import="java.time.LocalTime" %>



<% if(request.getParameter("registerFlight")!=null) 
{

	%>
	<%
	String departTime = request.getParameter("departureTime");
	LocalTime depTime = LocalTime.parse(departTime);

	String travelTime = request.getParameter("travelDuration");
	LocalTime travelDur = LocalTime.parse(travelTime);
	%>


	<jsp:useBean class="com.model.TripSourceDestination" id="tripSrcDest" scope="page"></jsp:useBean>
	<jsp:useBean id="airline" class="com.model.Airline" scope="page"></jsp:useBean>
	<jsp:useBean id="flightDetail" class="com.model.FlightDetail" scope="session"></jsp:useBean>
	<jsp:useBean id="runningDay" class="com.model.FlightRunningDays" scope="page"></jsp:useBean>

	<jsp:setProperty property="*" name="tripSrcDest"/>
	<jsp:setProperty property="*" name="airline"/>
	<jsp:setProperty property="*" name="runningDay"/>
	<jsp:setProperty property="flightId" name="flightDetail" param="flightId"/>
	<jsp:setProperty property="ticketPrice" name="flightDetail" param="ticketPrice"/>
	<jsp:setProperty property="departureTime" name="flightDetail" value="<%=depTime %>"/>
	<jsp:setProperty property="travelDuration" name="flightDetail" value="<%=travelDur %>"/>
	<jsp:setProperty property="airline" name="flightDetail" value="<%= airline%>"/>
	<jsp:setProperty property="tripSrcDest" name="flightDetail" value="<%= tripSrcDest %>"/>
	<jsp:setProperty property="flightRunningDays" name="flightDetail" value="<%= runningDay %>"/>
	<%System.out.println("flightDetail "+flightDetail); %>

<jsp:forward page="flightDetail/addFlight"></jsp:forward>

<%  
}
%>


<% if(request.getParameter("updateFlight") != null ) 
{

	%>
	<%
	String upDepartTime = request.getParameter("departureTime");
	LocalTime upDepTime = LocalTime.parse(upDepartTime);

	String upTravelTime = request.getParameter("travelDuration");
	LocalTime upTravelDur = LocalTime.parse(upTravelTime);
	%>


	<jsp:useBean class="com.model.TripSourceDestination" id="upTripSrcDest" scope="page"></jsp:useBean>
	<jsp:useBean id="upAirline" class="com.model.Airline" scope="page"></jsp:useBean>
	<jsp:useBean id="upFlightDetail" class="com.model.FlightDetail" scope="session"></jsp:useBean>
	<jsp:useBean id="upRunningDay" class="com.model.FlightRunningDays" scope="page"></jsp:useBean>

	<jsp:setProperty property="*" name="upTripSrcDest"/>
	<jsp:setProperty property="*" name="upAirline"/>
	<jsp:setProperty property="*" name="upRunningDay"/>

	<jsp:setProperty property="flightId" name="upFlightDetail" param="flightId"/>
	<jsp:setProperty property="ticketPrice" name="upFlightDetail" param="ticketPrice"/>	
	<jsp:setProperty property="departureTime" name="upFlightDetail" value="<%=upDepTime %>"/>
	<jsp:setProperty property="travelDuration" name="upFlightDetail" value="<%=upTravelDur %>"/>
	<jsp:setProperty property="airline" name="upFlightDetail" value="<%= upAirline%>"/>
	<jsp:setProperty property="tripSrcDest" name="upFlightDetail" value="<%= upTripSrcDest %>"/>
	<jsp:setProperty property="flightRunningDays" name="upFlightDetail" value="<%= upRunningDay %>"/>
		

	<jsp:forward page="flightDetail/updateFlightDtl"></jsp:forward>


<%  
}
%>
