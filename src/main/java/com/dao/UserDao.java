package com.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.User;
import com.util.HibernateUtil;

public class UserDao {
	
	public void saveUser(User user) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {			
			transaction = session.beginTransaction();		
			session.save(user);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	public String validate(String username,String password) {
	
		Transaction transaction = null;
		User user = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			String query = "from User u where u.username =:userName ";
			user=	(User) session.createQuery(query).setParameter("userName", username).uniqueResult();
	
			if(user != null && user.getPassword().equals(password)) {
				if(user.getUserType().equals("Admin"))
					return "Admin";
				else
					return user.getUserType();
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	
		return null;
	}

}
