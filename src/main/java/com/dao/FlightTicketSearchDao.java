package com.dao;

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
					+ "and fad.travelDate>=:travelDate and fad.noOfTickets>=:noOfTickets";
			
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
	
	public void bookTicket(FlightTicket flightTicket) {
		session = HibernateUtil.getSessionFactory().openSession();
		try 
		{
			transaction = session.beginTransaction();
			session.saveOrUpdate(flightTicket);
			transaction.commit();
			session.close();
		}
		catch(Exception e)
		{
			exceptionBlock(e);
		}

	}
	
	void exceptionBlock(Exception e) {
		if(transaction != null)
			transaction.rollback();

		e.printStackTrace();
	}
}
