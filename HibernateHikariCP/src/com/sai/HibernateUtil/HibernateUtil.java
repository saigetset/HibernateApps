package com.sai.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.sai.model.Students;

public class HibernateUtil {
	private static SessionFactory sessionFactory = null;
	private static Session session = null;
	
	private HibernateUtil(){}
	
	static {	
		sessionFactory = new Configuration().configure().addAnnotatedClass(Students.class).buildSessionFactory();
		System.out.println("session factory created");
	}
	public static Session getSession() {
		if(session == null)
			session= sessionFactory.openSession();
		return session;
	}
	
	public static void closeSession(Session session) {
		if(session!=null)
			session.close();
		if(sessionFactory!=null)
			sessionFactory.close();
	}
}
