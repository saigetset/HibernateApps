package com.sai.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.sai.HibernateUtil.HibernateUtil;
import com.sai.model.Students;

public class GetApplication {
	public static void main(String[] args) {
		Session session = null;		
		Transaction transaction=null;
		String updateQuery = "UPDATE com.sai.model.Students SET city=:city WHERE id=:id";
		String deleteQuery = "DELETE FROM com.sai.model.Students WHERE id=:id";
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery(updateQuery);
			query.setParameter("city", "vadlamudi");
			query.setParameter("id", 1);
			int val = query.executeUpdate();
			transaction.commit();
			if(val==1)
				System.out.println("Updated Successfully");
			else
				System.out.println("Updation failed");
			
			Transaction transaction2 = session.beginTransaction();
			//Deletion
			Query query2 = session.createQuery(deleteQuery);
			query2.setParameter("id", 3);
			int val2 = query2.executeUpdate();
			transaction2.commit();
			if(val2 == 1)
				System.out.println("Deleted Successfully");
			else
				System.out.println("Deletion failed");
			
		}catch(HibernateException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSession(session);
		}
	}
}
