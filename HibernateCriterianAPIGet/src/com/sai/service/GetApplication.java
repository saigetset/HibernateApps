package com.sai.service;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import com.sai.HibernateUtil.HibernateUtil;
import com.sai.model.Students;


public class GetApplication {
	@SuppressWarnings({ "deprecation", "unchecked" })
	public static void main(String[] args) {
		Session session = null;		
		try {
			session = HibernateUtil.getSession();
			Criteria criteria = session.createCriteria(Students.class);
			Criterion cond1= Restrictions.eq("age", 23);
			Criterion cond2= Restrictions.in("city", "guntur","tenali","hyd");
			criteria.add(cond1);
			criteria.add(cond2);
			ProjectionList projectionList = Projections.projectionList();
			projectionList.add(Projections.property("id"));
			projectionList.add(Projections.property("age"));
			projectionList.add(Projections.property("name"));
			projectionList.add(Projections.property("city"));
			criteria.setProjection(projectionList);
			Order order = Order.asc("name");//select id,age,name,city from students where age=23 and city in ('guntur','tenali','hyd') order by Name asc;
			criteria.addOrder(order);
			
			List<Object[]> list = criteria.list();
			list.forEach(row->{
				for(Object obj:row)
					System.out.print(obj+" ");
				System.out.println();
			});
			
		}catch(HibernateException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSession(session);
		}
	}
}
