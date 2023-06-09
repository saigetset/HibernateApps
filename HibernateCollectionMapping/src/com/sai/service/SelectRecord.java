package com.sai.service;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.sai.HibernateUtil.HibernateUtil;
import com.sai.model.*;

public class SelectRecord {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = null;	
		try {
			session = HibernateUtil.getSession();
			
			Query<Employee> query = session.createQuery("from com.sai.model.Employee");
			List<Employee> employees = query.getResultList();
			employees.forEach(System.out::println);
			
		}catch(HibernateException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSession(session);
		}
	}
}
