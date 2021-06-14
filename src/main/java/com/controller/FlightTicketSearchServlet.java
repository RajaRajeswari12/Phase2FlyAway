package com.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.FlightTicketSearchDao;
import com.model.FlightAvailabilityByDate;
import com.model.FlightTicket;
import com.model.PassengersDetail;
import com.model.SearchFlightDetailPojo;
import com.model.TripSourceDestination;

/**
 * Servlet implementation class FlightRunningDaysServlet
 */
@WebServlet("/flightSchedule/*")
public class FlightTicketSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FlightTicketSearchDao flightTicketSearchDao;	
	HttpSession session ;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FlightTicketSearchServlet() {
        super();
        flightTicketSearchDao = new FlightTicketSearchDao();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestPath = request.getPathInfo();
		
		switch(requestPath) {
		case "/searchForm":
			 session=request.getSession();
			List<String> tripDestinationList = flightTicketSearchDao.getDestinationList();
			List<String> tripSourceList = flightTicketSearchDao.getSourceList();
//			System.out.println(tripDestinationList);
			session.setAttribute("destinationList", tripDestinationList);
			session.setAttribute("srcList", tripSourceList);
			response.sendRedirect(request.getContextPath()+"/SearchForm.jsp");
			break;
		case "/searchFlight":
			 session=request.getSession();
			SearchFlightDetailPojo searchDetail = (SearchFlightDetailPojo)session.getAttribute("searchFlt");
//			System.out.println(searchDetail);
			List<FlightAvailabilityByDate> availableFlightList = flightTicketSearchDao.getAvailableFlight(searchDetail);
			session.setAttribute("availableFlightList", availableFlightList);
			response.sendRedirect(request.getContextPath()+"/SearchResult.jsp");
			break;
			
		case "/bookFlightTicket":
			 session=request.getSession();
			 Integer flightId = Integer.valueOf(request.getParameter("flightNo"));
			 LocalDate travelDate = LocalDate.parse(request.getParameter("travelDate"));
			 List<FlightAvailabilityByDate> availableFlights = (List<FlightAvailabilityByDate>) session.getAttribute("availableFlightList");
			 for(FlightAvailabilityByDate fad:availableFlights) {
				 if(fad.getFlightdetail().getFlightId() == flightId && fad.getTravelDate().isEqual(travelDate)) {
					 session.setAttribute("ChosenFlightDetail",fad);
					 break;
				 }
			 }
			 response.sendRedirect(request.getContextPath()+"/BookTicket.jsp");
			break;
		case "/bookTicket":
			session=request.getSession();
			List<PassengersDetail> passengerList = (List<PassengersDetail>) session.getAttribute("passengerList");
			FlightTicket flightTicket = (FlightTicket)session.getAttribute("flightTicket");
			flightTicket.setPassengerList(passengerList);
			flightTicketSearchDao.bookTicket(flightTicket);
			break;
			
		}
	}

}
