package com.sai.service;


import java.util.List;

import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.sai.HibernateUtil.HibernateUtil;
import com.sai.model.Students;


public class NativeSQLApp {
	@SuppressWarnings({ "unchecked", "deprecation" })
	public static void main(String[] args) {
		Session session = null;		
		try {
			session = HibernateUtil.getSession();
			Filter filter = session.enableFilter("FILTER_STUDENTS_BY_STATUS");
			filter.setParameter("statusType1", "changed");
			filter.setParameter("statusType2", "blocked");
			//Hibernate filters do not work with native SQL
			NativeQuery<Students> query = session.createSQLQuery("select * from Students where age=:age");
			query.setParameter("age", 23);
			query.addEntity(Students.class);
			List<Students> list = query.list();
			list.forEach(System.out::println);
			
			session.disableFilter("FILTER_STUDENTS_BY_STATUS");
			
			NativeQuery<Students> query2 = session.createSQLQuery("select * from Students where age=:age");
			query2.setParameter("age", 23);
			query2.addEntity(Students.class);
			List<Students> list2 = query2.list();
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
