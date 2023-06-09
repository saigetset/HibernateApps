package com.sai.service;

import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.sai.HibernateUtil.HibernateUtil;
import com.sai.model.Students;

public class GetApplication {
	public static void main(String[] args) {
		Session session = null;		
		try {
			session = HibernateUtil.getSession();

			Query<Students> query = session.getNamedQuery("HQL_GET_STUDENT_BY_ID");
			query.setParameter("id", 1);
			Optional<Students> result = query.uniqueResultOptional();
			if(result.isPresent())
				System.out.println(result);
			else
				System.out.println("Record not found");
			
		}catch(HibernateException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSession(session);
		}
	}
}
