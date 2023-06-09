package com.sai.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.type.StandardBasicTypes;

import com.sai.HibernateUtil.HibernateUtil;
import com.sai.model.Students;

public class GetApplication {
	@SuppressWarnings({ "deprecation", "unchecked" })
	public static void main(String[] args) {
		Session session = null;		
		try {
			session = HibernateUtil.getSession();
			
			//without Using Entity Object
			NativeQuery<Object[]> query = session.createSQLQuery("select * from Students where age=:age");
			query.setParameter("age", 23);
			List<Object[]> list = query.list();
			list.forEach(row ->{
				for(Object obj: row)
					System.out.print(obj+" ");
				System.out.println();
			});
			
			//Using Entity object
			NativeQuery<Students> query2 = session.createSQLQuery("select * from Students where age=:age");
			query2.setParameter("age", 23);
			query2.addEntity(Students.class);
			List<Students> list2 = query2.list();
			list2.forEach(System.out::println);
			
			//Selecting particular set of columns
			
			NativeQuery<Object[]> query3 = session.createSQLQuery("Select id,name from Students where age=:age");
			query3.setParameter("age",23);
			query3.addScalar("id",StandardBasicTypes.INTEGER);
			query3.addScalar("name",StandardBasicTypes.STRING);
			List<Object[]> list3 = query3.list();
			list3.forEach(row ->{
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
