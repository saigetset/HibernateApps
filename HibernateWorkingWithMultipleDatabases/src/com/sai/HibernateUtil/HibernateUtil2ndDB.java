package com.sai.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.sai.model.Students;

public class HibernateUtil2ndDB {
	private static SessionFactory sessionFactory = null;
	private static Session session = null;
	
	private HibernateUtil2ndDB(){}
	
	static {	
		sessionFactory = new Configuration().configure("SecondDB-hibernate.cfg.xml").addAnnotatedClass(Students.class).buildSessionFactory();
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