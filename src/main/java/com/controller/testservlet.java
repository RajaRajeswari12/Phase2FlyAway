package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FlightDetailDao;
import com.model.FlightAvailabilityByDate;

/**
 * Servlet implementation class testservlet
 */
@WebServlet("/testservlet")
public class testservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FlightDetailDao flightDetailDAO = new FlightDetailDao();
		List<FlightAvailabilityByDate> flightAvailabilityByDateList = flightDetailDAO.getFlightAvailabilityByDate();
		
		for(FlightAvailabilityByDate f:flightAvailabilityByDateList) {
			System.out.println(f);
		}
//		session.setAttribute("flightAvailabilityByDateList", flightAvailabilityByDateList);
		response.sendRedirect(request.getContextPath()+"/ListFlightTicketsAvailability.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
