package com.sai.service;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.sai.HibernateUtil.HibernateUtil;
import com.sai.model.*;

/*
 * creates only one table with all the fields from all the entities
gives null values for the fields which are not specified for the record
*/

public class SelectRecord {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = null;	
		try {
			session = HibernateUtil.getSession();
			Query<Payment> query = session.createQuery("from com.sai.model.Payment");
			List<Payment> list = query.list();
			list.forEach(System.out::println);
			
			Query<CardPayment> query1 = session.createQuery("from com.sai.model.CardPayment");
			List<CardPayment> list1 = query1.list();
			list1.forEach(System.out::println);
			
			Query<ChequePayment> query2 = session.createQuery("from com.sai.model.ChequePayment");
			List<ChequePayment> list2 = query2.list();
			list2.forEach(System.out::println);
			
		}catch(HibernateException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSession(session);
		}
	}
}
