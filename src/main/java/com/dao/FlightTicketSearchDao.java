package com.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.FlightAvailabilityByDate;
import com.model.FlightTicket;
import com.model.SearchFlightDetailPojo;
import com.model.TripSourceDestination;
import com.util.HibernateUtil;

public class FlightTicketSearchDao {
	Session session = null;
	Transaction transaction = null;
	
	public List<String> getSourceList(){
		session=HibernateUtil.getSessionFactory().openSession();
		List<String> tripSourceList = new ArrayList<String>();
		try {
			transaction = session.beginTransaction();
			String srcQuery="select distinct  concat(tsd.sourceCityName,' ',tsd.sourceCountry) from TripSourceDestination  tsd";
			tripSourceList = session.createQuery(srcQuery).list();
			
			transaction.commit();
			session.close();
		}
		catch(Exception e)
		{
			exceptionBlock(e);
		}
		return tripSourceList;
	}
	
	public List<String> getDestinationList(){
		session=HibernateUtil.getSessionFactory().openSession();
		List<String> tripDestinationList = new ArrayList<String>();
		try {
			transaction = session.beginTransaction();
			String destQuery="select distinct  concat(tsd.destCityName,' ',tsd.destCountry) from TripSourceDestination  tsd";
			tripDestinationList = session.createQuery(destQuery).list();
			
			transaction.commit();
			session.close();
		}
		catch(Exception e)
		{
			exceptionBlock(e);
		}
		return tripDestinationList;
	}
	
	public List<FlightAvailabilityByDate> getAvailableFlight(SearchFlightDetailPojo seacrhFlightDetail){
		List<FlightAvailabilityByDate> availableFlightList = new ArrayList<FlightAvailabilityByDate>();
		session=HibernateUtil.getSessionFactory().openSession();
		try {
			transaction = session.beginTransaction();
			String availableFlightQuery=" from FlightAvailabilityByDate  fad where fad.flightdetail.flightId in "
					+ "(select fd.flightId from FlightDetail fd where fd.tripSrcDest.tripId = (select tsd.tripId from TripSourceDestination tsd"
					+ " where concat(tsd.sourceCityName,' ',tsd.sourceCountry)=:sourceCityName and concat(tsd.destCityName,' ',tsd.destCountry)=:destCityName)) "
					+ "and fad.travelDate=:travelDate and fad.noOfTickets>=:noOfTickets";
			
			availableFlightList = session.createQuery(availableFlightQuery).setParameter("sourceCityName", seacrhFlightDetail.getSourceCityName())
					.setParameter("destCityName",seacrhFlightDetail.getDestinationCityName())
					.setParameter("travelDate",seacrhFlightDetail.getTravelDate())
					.setParameter("noOfTickets",seacrhFlightDetail.getNoOfPassengers()).list();
			
			transaction.commit();
			session.close();
		}
		catch(Exception e)
		{
			exceptionBlock(e);
		}
		return availableFlightList;
	}
	
	public FlightTicket bookTicket(FlightTicket flightTicket) {
		session = HibernateUtil.getSessionFactory().openSession();
		try 
		{
			transaction = session.beginTransaction();
			deductFlightSeat(flightTicket.getFlightNo(),flightTicket.getTravelDate(),flightTicket.getNoOfPassenger());
			session.save(flightTicket);
			transaction.commit();
			session.close();
			return flightTicket;
		}
		catch(Exception e)
		{
			exceptionBlock(e);
			return null;
		}

	}
	
	public void deductFlightSeat(int flightId,LocalDate travelDate,int noOfPassengers) {
		
			String deductTicketfromFlightAvailability = "update FlightAvailabilityByDate fad set fad.noOfTickets = fad.noOfTickets-:noOfPassengers where "
					+ " fad.flightdetail.flightId=:flightId and fad.travelDate = :travelDate";
			session.createQuery(deductTicketfromFlightAvailability).setParameter("noOfPassengers",noOfPassengers)
			.setParameter("flightId",flightId).setParameter("travelDate",travelDate).executeUpdate();
	
	}
	
	public FlightTicket getFlightTicket(int TicketNo) {
		session = HibernateUtil.getSessionFactory().openSession();
		FlightTicket flightTicket=new FlightTicket();
		try 
		{
			transaction = session.beginTransaction();
			String getTicketDetail = "from FlightTicket ft where ft.ticketId=:TicketNo";
			flightTicket=(FlightTicket)session.createQuery(getTicketDetail).setParameter("TicketNo",TicketNo).uniqueResult();
			transaction.commit();
			session.close();
		}
		catch(Exception e)
		{
			exceptionBlock(e);
		}
		
		return flightTicket;
	}
	
	void exceptionBlock(Exception e) {
		if(transaction != null)
			transaction.rollback();

		e.printStackTrace();
	}
}
