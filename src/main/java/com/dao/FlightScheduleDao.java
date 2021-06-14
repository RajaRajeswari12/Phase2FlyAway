package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.FlightAvailabilityByDate;
import com.model.FlightDetail;
import com.model.FlightRunningDays;
import com.model.FlightTicket;
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
	void exceptionBlock(Exception e) {
		if(transaction != null)
			transaction.rollback();

		e.printStackTrace();
	}

}
