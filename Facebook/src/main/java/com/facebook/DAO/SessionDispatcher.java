package com.facebook.DAO;

import org.hibernate.Session; 
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SessionDispatcher {
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	private static synchronized SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			Configuration configuration = new Configuration();
			configuration.configure();

			serviceRegistry = new StandardServiceRegistryBuilder().
					applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		return sessionFactory;
	}
	
	public static Session getSession(){
		return getSessionFactory().openSession();
	}
}
