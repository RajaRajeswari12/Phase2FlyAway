package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.FlightDetailDao;
import com.dao.FlightScheduleDao;
import com.model.Airline;
import com.model.FlightAvailabilityByDate;
import com.model.FlightDetail;
import com.model.FlightRunningDays;
import com.model.TripSourceDestination;

/**
 * Servlet implementation class TripDetailsRegistration
 */
@WebServlet("/flightDetail/*")

public class FlightDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FlightDetailDao flightDetailDAO;
	/* FlightScheduleDao flightScheduleDAO; */
	HttpSession session = null;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FlightDetailServlet() {
		super();
		flightDetailDAO = new FlightDetailDao(); 
	}


	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String requestPath = request.getPathInfo();
		System.out.println(requestPath);
		switch(requestPath) 
		{
		case "/addFlight":
			addNewFlightDetail(request,response);	
			break;

		case "/listFlight":
			getFlightDetailList(request, response);
			break;

		case "/deleteFlight":						
			deleteListedFlight(request,response);			
			break;

		case "/editFlight":
			editFlightDetail(request,response);
			break;

		case "/updateFlightDtl":
			updateFlightDetail(request,response);		
			break;

		case "/deleteFlightById":						
			deleteFlightByFlightId(request,response);			
			break;

		}
	}





	private void deleteFlightByFlightId(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Integer flightId = Integer.valueOf(request.getParameter("flightId"));
		List<Integer> flightids = new ArrayList<>();
		flightids.add(flightId);
		flightDetailDAO.deleteFlightDetails(flightids);
		getFlightDetailList(request,response);

	}




	private void addNewFlightDetail(HttpServletRequest request, HttpServletResponse response) throws IOException {
		session = request.getSession(false);
		FlightDetail fd = (FlightDetail) session.getAttribute("flightDetail");
		flightDetailDAO.registerFlightDetail(fd);
		getFlightDetailList(request, response);
	}


	private void updateFlightDetail(HttpServletRequest request, HttpServletResponse response) throws IOException {
		session = request.getSession(false);
		FlightDetail flightDetail=(FlightDetail) session.getAttribute("upFlightDetail");
		flightDetailDAO.updateFlightDetail(flightDetail);
		getFlightDetailList(request, response);
	}

	private void editFlightDetail(HttpServletRequest request, HttpServletResponse response) throws IOException {
		session = request.getSession(false);

		Integer flightId= Integer.valueOf(request.getParameter("flight"));		
		List<FlightDetail> flightList = (ArrayList) session.getAttribute("flightList");
		for(FlightDetail flightDetail:flightList) {
			if(flightId.equals(flightDetail.getFlightId())) {
				session.setAttribute("flightDtl",flightDetail);
				break;
			}
		}
		response.sendRedirect(request.getContextPath()+"/EditFlightDetail.jsp");
	}


	private void deleteListedFlight(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		String flightIdList[] = request.getParameterValues("flightID");
		
		if(flightIdList != null && flightIdList.length > 0){
			List<Integer> flightids = new ArrayList<>();
			for(String s:flightIdList) {
				flightids.add(Integer.valueOf(s));			
			}
			flightDetailDAO.deleteFlightDetails(flightids);
		}

		getFlightDetailList(request,response);
	}




	private void getFlightDetailList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		session = request.getSession(false);		
		List<FlightDetail> flightList = flightDetailDAO.getFlightDetail();
		session.setAttribute("flightList", flightList);
		response.sendRedirect(request.getContextPath()+"/FlightList.jsp");
	}



}

