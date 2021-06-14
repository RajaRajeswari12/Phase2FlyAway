package com.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.model.Airline;
import com.model.FlightAvailabilityByDate;
import com.model.FlightDetail;
import com.model.FlightRunningDays;
import com.model.TripSourceDestination;

import com.util.HibernateUtil;

public class FlightDetailDao {

	Session session = null;
	Transaction transaction = null;

	
	

	public void registerFlightDetail(FlightDetail flightDetail) {

		session =HibernateUtil.getSessionFactory().openSession();
		try {

			transaction = session.beginTransaction();

			flightDetail = checkFlightDetail(flightDetail);
			session.saveOrUpdate(flightDetail);
			transaction.commit();
			session.close();
		}
		catch(Exception e)
		{
			exceptionBlock(e);
		}

	}

	private FlightDetail checkFlightDetail(FlightDetail flightDetail) {

		String trip_Src_Dest = "from TripSourceDestination tripSrc where tripSrc.sourceCityName = :sourceCityName and tripSrc.destCityName=:destCityName";
		List<TripSourceDestination> sourceDestList = session.createQuery(trip_Src_Dest).setProperties(flightDetail.getTripSrcDest()).list();			

		String Airline = "from Airline ar where ar.airLineName=:airLineName";
		List<Airline> airlineList = session.createQuery(Airline).setProperties(flightDetail.getAirline()).list();

		if(sourceDestList != null && !sourceDestList.isEmpty() )
		{
			flightDetail.setTripSrcDest(sourceDestList.get(0));
		}
		if(airlineList != null && !airlineList.isEmpty())
		{
			flightDetail.setAirline(airlineList.get(0));
		}

		return flightDetail;
	}





	

	
	public void deleteFlightRunningDaydetail(int flightRunId) {
		session = HibernateUtil.getSessionFactory().openSession();
		try {

			transaction = session.beginTransaction();				

			String deleteFlightAvailablebyDate =
					"delete from FlightAvailabilityByDate fad where fad.flightdetail.flightId in (select fd.flightId from FlightRunningDays fd " +
							"where fd.flightRunningId=:flightRunId )";			

			session.createQuery(deleteFlightAvailablebyDate).setParameter("flightRunId", flightRunId).executeUpdate();
			FlightRunningDays flightRunningDays = session.get(FlightRunningDays.class,flightRunId);
			session.delete(flightRunningDays);
			transaction.commit(); 
			session.close(); 
		}
		catch(Exception e) {
			exceptionBlock(e);
		}

	}

	
	public void deleteFlightDetails(List<Integer> flightId) 
	{
		session = HibernateUtil.getSessionFactory().openSession();
		try {

			transaction = session.beginTransaction();				

			String deleteFlightAvailablebyDate =
					"delete from FlightAvailabilityByDate fad where fad.flightdetail.flightId in (:flightId)";				  
			session.createQuery(deleteFlightAvailablebyDate).setParameter("flightId", flightId).executeUpdate();

			
			String getFlightScheduleIdsQuery = "select fd.flightRunningDays.flightScheduleId from FlightDetail fd where fd.flightId in (:flightId)";
			List<String> flightScheduleIds = session.createQuery(getFlightScheduleIdsQuery).setParameter("flightId", flightId).list();
			 
			 
			String deleteFlightDetail = "delete from FlightDetail fd where fd.flightId in (:flightId)";
			session.createQuery(deleteFlightDetail).setParameter("flightId", flightId).executeUpdate();

			  String deleteFlightRunningDay =
			  "delete from FlightRunningDays frd  where frd.flightScheduleId in (:flightScheduleIds)"
			  ;
			  
			  session.createQuery(deleteFlightRunningDay).setParameter("flightScheduleIds",  flightScheduleIds).executeUpdate();
			transaction.commit();
			session.close();
		}
		catch(Exception e)
		{
			exceptionBlock(e);
		}
	
	}

	
	

	public List<FlightDetail> getFlightDetail(){
		List<FlightDetail> flightDetailList = new ArrayList<>();
		session = HibernateUtil.getSessionFactory().openSession();
		try 
		{
			transaction = session.beginTransaction();
			flightDetailList = session.createQuery("from FlightDetail").list();
			
			transaction.commit();
			session.close();
		}
		catch(Exception e)
		{
			exceptionBlock(e);
		}

		return 	flightDetailList;
	}
	
	
	
	
	

	
	/*
	 * public FlightDetail getFlightDetail(int flightId) { FlightDetail flightDetail
	 * = new FlightDetail(); session =
	 * HibernateUtil.getSessionFactory().openSession(); try { transaction =
	 * session.beginTransaction(); flightDetail =
	 * session.get(FlightDetail.class,flightId); transaction.commit();
	 * session.close(); } catch(Exception e) { exceptionBlock(e); } return
	 * flightDetail; }
	 */
	
	public void updateFlightDetail(FlightDetail flightDetail) {
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			transaction = session.beginTransaction();
			flightDetail = checkFlightDetail(flightDetail);
			session.update(flightDetail);
			transaction.commit();
			session.close();
		}
		catch(Exception e) {
			exceptionBlock(e);
		}
	}
	
	void exceptionBlock(Exception e) {
		if(transaction != null)
			transaction.rollback();

		e.printStackTrace();
	}

	
	public void populateFlightDetail(int dayCount,LocalDate startDate) {
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			transaction = session.beginTransaction();
			/* Query query = */ session.createSQLQuery(
				    "CALL populateFlightDetailByDate(:dayCount,:startDate);")
				    .addEntity(FlightAvailabilityByDate.class)
				    .setParameter("dayCount", dayCount)
				    .setParameter("startDate",startDate).executeUpdate();
				            
//				List result = query.executeUpdate();
				/*
				 * for(int i=0; i<result.size(); i++){ FlightAvailabilityByDate
				 * flightAvailabilityByDate = (FlightAvailabilityByDate)result.get(i);
				 * System.out.println(flightAvailabilityByDate); }
				 */
//			session.update(flightDetail);
			transaction.commit();
			session.close();
		}
		catch(Exception e) {
			exceptionBlock(e);
		}
	}
	
	
	public List<FlightAvailabilityByDate> getFlightAvailabilityByDate(){
		List<FlightAvailabilityByDate> flightAvailabilityByDateList = new ArrayList<FlightAvailabilityByDate>();
		session = HibernateUtil.getSessionFactory().openSession();
		try 
		{
			transaction = session.beginTransaction();
			flightAvailabilityByDateList = session.createQuery("from FlightAvailabilityByDate").getResultList();
			System.out.println(flightAvailabilityByDateList.size());
			transaction.commit();
			session.close();
		}
		catch(Exception e)
		{
			exceptionBlock(e);
		}

		return flightAvailabilityByDateList;
	}
}
