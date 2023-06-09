package com.sai.service;

import java.util.List;
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

			// Prepare Query object to hold HQL
			Query<Students> query = session.createQuery("FROM com.sai.model.Students");// select * from Students;
			// Execute the query
			List<Students> allStudents = query.list();//query.getResultList() also works same
			// process the List Object
			allStudents.forEach(System.out::println);
			
			//selecting one column from table
			Query<String> query2 = session.createQuery("SELECT name FROM com.sai.model.Students");
			List<String> namesOfAllStudents = query2.list();
			System.out.println("Name");
			System.out.println("----");
			for(String name:namesOfAllStudents)
				System.out.println(name);
			
			//selecting more than one column 
			Query<Object[]> query3 = session.createQuery("SELECT id,name FROM com.sai.model.Students");
			List<Object[]> idAndNames = query3.list();
			System.out.println("ID  NAME");
			System.out.println("--  ----");
			idAndNames.forEach(row -> {
				for(Object i:row)
					System.out.print(i+"  ");
				System.out.println();
			});
			
			//Using Named parameters
			Query<String> query4 = session.createQuery("SELECT name FROM com.sai.model.Students WHERE age=:iage");
			query4.setParameter("iage",23);
			List<String> iAgeStudents = query4.list();
			System.out.println("Name");
			System.out.println("----");		
			for(String name:iAgeStudents)
				System.out.println(name);
			
			//Using uniqueResult() if the resultset has only one record
			Query<Students> query5 = session.createQuery("FROM com.sai.model.Students WHERE id=:sid");
			query5.setParameter("sid", 1);
			Students result = query5.uniqueResult();
			if(result!=null)
				System.out.println(result);
			else
				System.out.println("Record not found");
			
			//Using uniqueResultOptional() 
			Query<Object[]> query6 = session.createQuery("SELECT name,city FROM com.sai.model.Students WHERE id=:sid");
			query6.setParameter("sid", 1);
			Optional<Object[]> resultOptional = query6.uniqueResultOptional();
			if(resultOptional.isPresent()){
				Object[] arr = resultOptional.get();
				System.out.println("Name: "+arr[0]+" City: "+arr[1]);
			}
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
