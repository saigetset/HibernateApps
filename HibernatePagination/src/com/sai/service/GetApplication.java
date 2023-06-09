package com.sai.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.sai.HibernateUtil.HibernateUtil;
import com.sai.model.Students;

public class GetApplication {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = null;		
		try {
			session = HibernateUtil.getSession();
			Query<Students> query = session.createQuery("from com.sai.model.Students");
			//query.setFirstResult(0);
			//query.setFirstResult(1);
			query.setFirstResult(2);
			query.setMaxResults(3);
			List<Students> list = query.getResultList();
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
