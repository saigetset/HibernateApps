package com.sai.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sai.dto.Student;

public class HibernateUtil {
	private static Session session=null;
	private static SessionFactory sessionFactory=null;
	
	static {
		sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
	}
	
	public static Session getSession() {
		if(session == null) {
			session = sessionFactory.openSession();
		}
		System.out.println("Session got created...");
		return session;
	}
	
	public static void closeSession(Session session) {
		if(session!=null)
			session.close();
		if(sessionFactory!=null)
			sessionFactory.close();
	}
}
