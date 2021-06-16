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


@WebServlet("/flightTicketSchedule/*")
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
			searchForm(request,response);
			break;
		case "/searchFlight":
			searchFlight(request,response);
			break;
			
		case "/bookFlightTicket":
			bookFlightTicket(request,response);
			break;
		case "/bookTicket":
			payAndBookTicket(request,response);
			break;
			
		case "/bookedTicket":
			getBookedTicketDetail(request,response);
			break;
			
		}
	}

	private void getBookedTicketDetail(HttpServletRequest request, HttpServletResponse response) throws IOException {
		session=request.getSession(false);
		Integer ticketNo = Integer.valueOf(request.getParameter("TicketNo"));
		session.removeAttribute("flightTicket");
		FlightTicket getFlightTicketDetail = flightTicketSearchDao.getFlightTicket(ticketNo);
		session.setAttribute("flightTicket",getFlightTicketDetail);
		response.sendRedirect(request.getContextPath()+"/Ticket.jsp?getTicket=1");
		
	}

	private void payAndBookTicket(HttpServletRequest request, HttpServletResponse response) throws IOException {
		session=request.getSession(false);
		List<PassengersDetail> passengerList = (List<PassengersDetail>) session.getAttribute("passengerList");
		FlightTicket flightTicket = (FlightTicket)session.getAttribute("flightTicket");
		flightTicket.setPassengerList(passengerList);
		FlightTicket savedFlightTicket = flightTicketSearchDao.bookTicket(flightTicket);
		if(savedFlightTicket != null) {
		response.sendRedirect(request.getContextPath()+"/Ticket.jsp");
		}
		else {
			response.sendRedirect(request.getContextPath()+"/BookingFailed.jsp");
		}
	}

	private void bookFlightTicket(HttpServletRequest request, HttpServletResponse response) throws IOException {
		 session=request.getSession(false);
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
		
	}

	private void searchFlight(HttpServletRequest request, HttpServletResponse response) throws IOException {
		 session=request.getSession(false);
			SearchFlightDetailPojo searchDetail = (SearchFlightDetailPojo)session.getAttribute("searchFlt");
			List<FlightAvailabilityByDate> availableFlightList = flightTicketSearchDao.getAvailableFlight(searchDetail);
			session.setAttribute("availableFlightList", availableFlightList);
			response.sendRedirect(request.getContextPath()+"/SearchResult.jsp");
		
	}

	private void searchForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		 session=request.getSession(false);
			List<String> tripDestinationList = flightTicketSearchDao.getDestinationList();
			List<String> tripSourceList = flightTicketSearchDao.getSourceList();

			session.setAttribute("destinationList", tripDestinationList);
			session.setAttribute("srcList", tripSourceList);
			response.sendRedirect(request.getContextPath()+"/SearchForm.jsp");
		
	}

}
