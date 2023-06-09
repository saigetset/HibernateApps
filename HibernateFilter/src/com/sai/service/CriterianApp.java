package com.sai.service;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.sai.HibernateUtil.HibernateUtil;
import com.sai.model.Students;


public class CriterianApp {
	@SuppressWarnings({ "unchecked", "deprecation" })
	public static void main(String[] args) {
		Session session = null;		
		try {
			session = HibernateUtil.getSession();
			Filter filter = session.enableFilter("FILTER_STUDENTS_BY_STATUS");
			filter.setParameter("statusType1", "changed");
			filter.setParameter("statusType2", "blocked");
			Criteria criteria = session.createCriteria(Students.class);
			Criterion cond1 = Restrictions.eq("age",23);
			criteria.add(cond1);
			List<Students> list = criteria.list();
			list.forEach(System.out::println);
			
			session.disableFilter("FILTER_STUDENTS_BY_STATUS");
			
			Criteria criteria2 = session.createCriteria(Students.class);
			Criterion cond2 = Restrictions.eq("age",23);
			criteria2.add(cond2);
			List<Students> list2 = criteria2.list();
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
