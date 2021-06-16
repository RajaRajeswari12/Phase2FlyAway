package com.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.FlightScheduleDao;
import com.model.FlightAvailabilityByDate;

/**
 * Servlet implementation class FlightScheduleServlet
 */
@WebServlet("/flightSchedule/*")
public class FlightScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FlightScheduleDao flightScheduleDAO; 
	HttpSession session = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FlightScheduleServlet() {
        super();
        flightScheduleDAO = new FlightScheduleDao();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestPath = request.getPathInfo();
		System.out.println(requestPath);
		switch(requestPath) {
		case "/listFlightDtlByDate":
			getFlightDetailsByTripDateList(request,response);
		break;
		case "/populateFlightDtl":
			populateFlightDetail(request,response);
			break;
		case "/deleteFlightByTripDate":						
			deleteListedFlightByTripDate(request,response);			
			break;
		case "/deleteFlightByTripDateById":						
			deleteListedFlightByTripDateById(request,response);			
			break;
		}
	}
	
	
	private void deleteListedFlightByTripDateById(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Integer flightId = Integer.valueOf(request.getParameter("flightTripId"));
		List<Integer> FlightTripIdList = new ArrayList<>();
		FlightTripIdList.add(flightId);
		flightScheduleDAO.deleteFlightDetailsByTripIds(FlightTripIdList);
		getFlightDetailsByTripDateList(request,response);
		
	}


	private void deleteListedFlightByTripDate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String[] FlightTripIdListString = request.getParameterValues("TripScheduleId");
		List<Integer> FlightTripIdListInt = new ArrayList<>();

		for(String s:FlightTripIdListString) {
			System.out.println(s);
			FlightTripIdListInt.add(Integer.valueOf(s));			
		}
		flightScheduleDAO.deleteFlightDetailsByTripIds(FlightTripIdListInt);
		getFlightDetailsByTripDateList(request,response);
		
	}
	
	private void populateFlightDetail(HttpServletRequest request, HttpServletResponse response) throws IOException {
		session = request.getSession(false);
		Integer dayCount = Integer.valueOf(request.getParameter("DayCount"));
		LocalDate startDate = LocalDate.parse(request.getParameter("populateStartDate"));
		flightScheduleDAO.populateFlightDetail(dayCount, startDate);
		getFlightDetailsByTripDateList(request,response);
		
	}

	private void getFlightDetailsByTripDateList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		session = request.getSession(false);
		List<FlightAvailabilityByDate> flightAvailabilityByDateList = flightScheduleDAO.getFlightAvailabilityByDate();
		session.setAttribute("flightAvailabilityByDateList", flightAvailabilityByDateList);
		response.sendRedirect(request.getContextPath()+"/ListFlightTicketsAvailability.jsp");		
	}

}
