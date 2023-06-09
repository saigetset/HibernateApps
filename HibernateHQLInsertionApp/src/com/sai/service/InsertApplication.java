package com.sai.service;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.sai.HibernateUtil.HibernateUtil;

//Insertion in HQL refers to copying of record from one table to another
public class InsertApplication {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		Session session = null;	
		String insertionQuery="INSERT INTO com.sai.model.NewStudents(id,name,age,city)"
				+ " SELECT s.id,s.name,s.age,s.city FROM com.sai.model.Students as s WHERE age=:age";
		try {
			session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			Query query = session.createQuery(insertionQuery);
			query.setParameter("age", 23);
			int val = query.executeUpdate();
			transaction.commit();
			if(val>0)
				System.out.println("Insertion Successful");
			else
				System.out.println("Insertion failed");
			
		}catch(HibernateException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSession(session);
		}
	}
}
