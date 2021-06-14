package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AirlineDao;
import com.model.Airline;
import com.model.FlightDetail;

/**
 * Servlet implementation class AirlineServlet
 */
@WebServlet("/Airline/*")
public class AirlineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AirlineDao airlineDAO; 
	HttpSession session = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AirlineServlet() {
        super();
        airlineDAO = new AirlineDao();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestPath = request.getPathInfo();
		switch(requestPath) 
		{
		case "/addAirline":
			addNewAirline(request,response);	
			break;

		case "/listAirline":
			getAirlineList(request, response);
			break;

		case "/deleteAirline":						
			deleteAirline(request,response);			
			break;

		case "/editAirline":
			editAirline(request,response);
			break;

		case "/updateFlightDtl":
			updateAirline(request,response);		
			break;
		}
	}

	private void updateAirline(HttpServletRequest request, HttpServletResponse response) {
		
		
	}

	private void editAirline(HttpServletRequest request, HttpServletResponse response) {
		
		
	}

	private void deleteAirline(HttpServletRequest request, HttpServletResponse response) {
		
		
	}

	private void getAirlineList(HttpServletRequest request, HttpServletResponse response) {
		
		
	}

	private void addNewAirline(HttpServletRequest request, HttpServletResponse response) {
		session = request.getSession();
		Airline airline = (Airline) session.getAttribute("airline");
		airlineDAO.registerAirline(airline);;
		getAirlineList(request, response);
		
	}

}
