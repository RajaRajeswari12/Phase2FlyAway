package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.TripSourceDestination;
import com.util.HibernateUtil;

public class TripDao {
	Session session = null;
	Transaction transaction = null;
	
	public void srcDestInsert(TripSourceDestination tripSrcDest) 
	{
		session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			transaction = session.beginTransaction();
			session.saveOrUpdate(tripSrcDest);
			transaction.commit();
			session.close();

		}
		catch(Exception e) 
		{
			exceptionBlock(e);
		}

	}
	
	public void deleteSrcDestination(int srcDestId) {
		session = HibernateUtil.getSessionFactory().openSession();
		try {

			transaction = session.beginTransaction();				

			String deleteFlightAvailablebyDate =
					"delete from FlightAvailabilityByDate fad where fad.flightdetail.flightId = (select fd.flightId from FlightDetail fd " +
							"where fd.tripSrcDest.tripId=:srcDesId )";				  
			session.createQuery(deleteFlightAvailablebyDate).setParameter("srcDesId", srcDestId).executeUpdate();

			String deleteFlightRunningDay = "delete from FlightRunningDays frd  where frd.flightdetail.flightId = (select fd.flightId from FlightDetail fd " 
					+ "where fd.tripSrcDest.tripId=:srcDesId )";				  

			session.createQuery(deleteFlightRunningDay).setParameter("srcDesId", srcDestId).executeUpdate();

			String deleteFlightDetail = "delete from FlightDetail fd where fd.tripSrcDest.tripId=:srcDesId";
			session.createQuery(deleteFlightDetail).setParameter("srcDesId", srcDestId).executeUpdate();


			TripSourceDestination trp = session.get(TripSourceDestination.class,srcDestId);
			session.delete(trp);
			transaction.commit(); 
			session.close(); 


		}
		catch(Exception e) {
			exceptionBlock(e);
		}
	}
	
	public List<TripSourceDestination> getTripSourceDestinationList(){
		List<TripSourceDestination> tripSourceDestList = new ArrayList<>();
		session = HibernateUtil.getSessionFactory().openSession();
		try 
		{
			transaction = session.beginTransaction();
			tripSourceDestList = session.createQuery("from TripSourceDestination").list();

			System.out.println(tripSourceDestList);
			transaction.commit();
			session.close();
		}
		catch(Exception e)
		{
			exceptionBlock(e);
		}

		return tripSourceDestList;
	}
	
	void exceptionBlock(Exception e) {
		if(transaction != null)
			transaction.rollback();

		e.printStackTrace();
	}

}
