package com.sai.service;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.sai.HibernateUtil.HibernateUtil;
import com.sai.model.Student;

public class SelectRecord {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = null;	
		try {
			session = HibernateUtil.getSession();
			Query<Student> query = session.createQuery("from com.sai.model.Student where address.city=:city");
			query.setParameter("city", "Tenali");
			List<Student> list = query.list();
			list.forEach(System.out::println);
			
		}catch(HibernateException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSession(session);
		}
	}
}
