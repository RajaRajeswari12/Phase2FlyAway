package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.Airline;
import com.util.HibernateUtil;

public class AirlineDao {
	Session session = null;
	Transaction transaction = null;
	
	public void registerAirline(Airline airline) 
	{

		session =HibernateUtil.getSessionFactory().openSession();
		try 
		{
			transaction = session.beginTransaction();
			session.saveOrUpdate(airline);
			transaction.commit();
			session.close();
		}
		catch(Exception e) 
		{
			exceptionBlock(e);
		}


	}
	
	public void deleteAirline(int AirlineId) {

		session = HibernateUtil.getSessionFactory().openSession();
		try {

			transaction = session.beginTransaction();				

			String deleteFlightAvailablebyDate =
					"delete from FlightAvailabilityByDate fad where fad.flightdetail.flightId in (select fd.flightId from FlightDetail fd " +
							"where fd.airline.airlineId=:airlineId )";				  
			session.createQuery(deleteFlightAvailablebyDate).setParameter("airlineId", AirlineId).executeUpdate();

			String deleteFlightRunningDay = "delete from FlightRunningDays frd  where frd.flightdetail.flightId in (select fd.flightId from FlightDetail fd " 
					+ "where fd.airline.airlineId=:airlineId)";				  

			session.createQuery(deleteFlightRunningDay).setParameter("airlineId", AirlineId).executeUpdate();

			String deleteFlightDetail = "delete from FlightDetail fd where fd.airline.airlineId=:airlineId";
			session.createQuery(deleteFlightDetail).setParameter("airlineId", AirlineId).executeUpdate();


			Airline airline = session.get(Airline.class,AirlineId);
			session.delete(airline);
			transaction.commit(); 
			session.close(); 

		}
		catch(Exception e) {
			exceptionBlock(e);
		}

	}
	public List<Airline> getAirline(){
		List<Airline> airlineList = new ArrayList<>();
		session = HibernateUtil.getSessionFactory().openSession();
		try 
		{
			transaction = session.beginTransaction();

			airlineList = session.createQuery("from Airline").list();
			transaction.commit();
			session.close();

		}
		catch(Exception e)
		{
			exceptionBlock(e);
		}

		return 	airlineList;
	}
	
	void exceptionBlock(Exception e) {
		if(transaction != null)
			transaction.rollback();

		e.printStackTrace();
	}
}
