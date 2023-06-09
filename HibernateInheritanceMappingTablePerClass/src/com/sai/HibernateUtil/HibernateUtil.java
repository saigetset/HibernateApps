package com.sai.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.sai.model.Payment;
import com.sai.model.CardPayment;
import com.sai.model.ChequePayment;

public class HibernateUtil {
	private static SessionFactory sessionFactory = null;
	private static Session session = null;
	
	private HibernateUtil(){}
	
	static {		
		sessionFactory = new Configuration().configure()
		.addAnnotatedClass(Payment.class)
		.addAnnotatedClass(CardPayment.class)
		.addAnnotatedClass(ChequePayment.class)
		.buildSessionFactory();
	}
	public static Session getSession() {
		if(session == null) {
			session= sessionFactory.openSession();
		}
		return session;
	}
	
	public static void closeSession(Session session) {
		if(session!=null)
			session.close();
		if(sessionFactory!=null)
			sessionFactory.close();
	}
}
