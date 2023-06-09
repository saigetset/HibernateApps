package com.sai.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sai.dto.Students;
public class HibernateUtil {
	private static SessionFactory sessionFactory= null;
	private static Session session = null;
	private HibernateUtil() {}

	static {
		sessionFactory = new Configuration().configure().addAnnotatedClass(Students.class).buildSessionFactory();
	}
	
	public static Session getSession() throws HibernateException {
		if(session==null)
			session = sessionFactory.openSession();
		return session;
	}
	
	public static void closeSession(Session session) {
		if(session!=null)
			session.close();
		if(sessionFactory!=null)
			sessionFactory.close();
	}
}
