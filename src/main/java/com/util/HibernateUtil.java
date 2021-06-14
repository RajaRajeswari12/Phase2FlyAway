package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {

private static final SessionFactory sessionFactory= buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		try {
			Configuration configuration = new Configuration();
			
//			 configuration.addAnnotatedClass(User.class); 
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			return configuration.buildSessionFactory(serviceRegistry);
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException( "There was an error building the session factory");
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	/*private static StandardServiceRegistry registry;
	
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		
		if(sessionFactory == null) {
			try {
			registry = new StandardServiceRegistryBuilder().build();
			
			MetadataSources metasource = new MetadataSources(registry);
			
			Metadata metaData = metasource.getMetadataBuilder().build();
			
			sessionFactory = metaData.getSessionFactoryBuilder().build();
			}catch(Exception e) {
				if(registry != null) {
					StandardServiceRegistryBuilder.destroy(registry);
				}
			}
			
		}
		return sessionFactory;
	}
	
	
	 public static void shutdown() {
	        if (registry != null) {
	            StandardServiceRegistryBuilder.destroy(registry);
	        }
	    }*/
}
