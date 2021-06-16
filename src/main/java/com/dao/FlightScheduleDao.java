package com.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.FlightAvailabilityByDate;
import com.model.FlightRunningDays;
import com.util.HibernateUtil;

public class FlightScheduleDao {
	Session session = null;
	Transaction transaction = null;

	public void registerFlightRunningDays(FlightRunningDays flightRunningDays) {

		session =HibernateUtil.getSessionFactory().openSession();
		try
		{ 
			transaction = session.beginTransaction();
			session.saveOrUpdate(flightRunningDays);
			transaction.commit(); 
			session.close(); 
		}
		catch(Exception e) 
		{ 
			exceptionBlock(e);
		}
	}

	public void deleteFlightRunningOnSpecificDays(int flightId,List runningDaysList) {
		session = HibernateUtil.getSessionFactory().openSession();
		try
		{
			transaction = session.beginTransaction();

			String deleteFlightSpecificRunningDay = "delete from FlightAvailabilityByDate fad where fad.flightdetail.flightId=:flightId"
					+ " and weekday(fad.travelDate)+1 in (:runningDaysList) and fad.travelDate >= current_date ";

			session.createQuery(deleteFlightSpecificRunningDay).setParameter("flightId", flightId).setParameter("runningDaysList", runningDaysList).executeUpdate();
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


	public void deleteFlightDetailsByTripIds(List<Integer> FlightTripId) 
	{
		session = HibernateUtil.getSessionFactory().openSession();
		try {

			transaction = session.beginTransaction();				

			
			String deleteFlightAvailablebyDate = "delete from FlightAvailabilityByDate fad where fad.flightTripId in (:FlightTripId)";
			session.createQuery(deleteFlightAvailablebyDate).setParameter("FlightTripId", FlightTripId).executeUpdate();

			
			transaction.commit();
			 session.close();
		}
		catch(Exception e)
		{
			exceptionBlock(e);
		}

	}

	public void populateFlightDetail(int dayCount,LocalDate startDate) {
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			transaction = session.beginTransaction();
			session.createSQLQuery(
					"CALL populateFlightDetailByDate(:dayCount,:startDate);")
			.addEntity(FlightAvailabilityByDate.class)
			.setParameter("dayCount", dayCount)
			.setParameter("startDate",startDate).executeUpdate();
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



/*
 * public List<FlightRunningDays> getFlightRunningDays(){
 * List<FlightRunningDays> flightRunningDaysList = new ArrayList<>(); session =
 * HibernateUtil.getSessionFactory().openSession(); try { transaction =
 * session.beginTransaction(); flightRunningDaysList =
 * session.createQuery("from FlightRunningDays").list(); transaction.commit();
 * session.close(); } catch(Exception e) { exceptionBlock(e); } return
 * flightRunningDaysList; }
 */

/*
 * public void deleteFlightRunningDaydetail(int flightRunId) { session =
 * HibernateUtil.getSessionFactory().openSession(); try {
 * 
 * transaction = session.beginTransaction();
 * 
 * String deleteFlightAvailablebyDate =
 * "delete from FlightAvailabilityByDate fad where fad.flightdetail.flightId in (select fd.flightId from FlightRunningDays fd "
 * + "where fd.flightRunningId=:flightRunId )";
 * 
 * session.createQuery(deleteFlightAvailablebyDate).setParameter("flightRunId",
 * flightRunId).executeUpdate(); FlightRunningDays flightRunningDays =
 * session.get(FlightRunningDays.class,flightRunId);
 * session.delete(flightRunningDays); transaction.commit(); session.close(); }
 * catch(Exception e) { exceptionBlock(e); }
 * 
 * }
 */

/*
 * public FlightRunningDays getFlightRunningDayById(int flightId){
 * FlightRunningDays flightRunningDays= new FlightRunningDays(); session =
 * HibernateUtil.getSessionFactory().openSession(); try { transaction =
 * session.beginTransaction(); flightRunningDays = (FlightRunningDays) session.
 * createQuery("from FlightRunningDays frd where frd.flightId=:flightId ").
 * setParameter("flightId",flightId).uniqueResult(); transaction.commit();
 * session.close(); } catch(Exception e) { exceptionBlock(e); }
 * 
 * return flightRunningDays; }
 */

/*
 * public void updateFlightRunningDays(FlightRunningDays flightRunningDays) {
 * 
 * session =HibernateUtil.getSessionFactory().openSession(); try { transaction =
 * session.beginTransaction(); // FlightDetail flightDetail =
 * session.get(FlightDetail.class,flightRunningDays.getFlightId()); //
 * flightRunningDays.setFlightdetail(flightDetail);
 * 
 * session.update(flightRunningDays); transaction.commit(); session.close(); }
 * catch(Exception e) { exceptionBlock(e); } }
 */