package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.model.User;

/**
 * Servlet implementation class UserRegisterServlet
 */
@WebServlet("/UserRegisterServlet/*")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao dao = new UserDao();

	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserRegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestPath = request.getPathInfo();

		switch(requestPath) {
		case "/login":
			validateUser(request,response);
			break;
		case "/register":
			registerUser(request,response);
			break;

		case "/logout":
			logoutUser(request,response);
			break;
		}
	}

	private void logoutUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession(false);
		if(session != null ) {
			session.removeAttribute("username");
			session.removeAttribute("upFlightDetail");
			session.removeAttribute("flightList");
			session.removeAttribute("flightAvailabilityByDateList");
			session.removeAttribute("flightDetail");
			session.removeAttribute("destinationList");
			session.removeAttribute("srcList");
			session.removeAttribute("availableFlightList");
			session.removeAttribute("ChosenFlightDetail");
			session.removeAttribute("flightTicket");
			session.invalidate();
			response.sendRedirect(request.getContextPath()+"/AdminLogin.jsp");
		}
	}

	
	private void registerUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession(false);
		User user=(User) session.getAttribute("RegisterUser");
		dao.saveUser(user);
		session.removeAttribute("RegisterUser");
		response.sendRedirect(request.getContextPath()+"/AdminLogin.jsp");
	}

	
	private void validateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		String password= request.getParameter("password");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		HttpSession session = request.getSession();

		String userType = dao.validate(userName, password);
		if(userType != null) {
			if( userType.equals("Admin")) {
				session.setAttribute("userType", userType);
				response.sendRedirect(request.getContextPath()+"/AdminMenu.jsp");
			}else  {
				session.setAttribute("userType", userType);
				session.setAttribute("userName", userName);
				response.sendRedirect(request.getContextPath()+"/UserMenu.jsp");
			}
		}
		else {		
			session.setAttribute("InvalidLogin","Invalid Login Credentials");		
			response.sendRedirect(request.getContextPath()+"/AdminLogin.jsp");
		}
	}

}
