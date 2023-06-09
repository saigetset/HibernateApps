package com.sai.service;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sai.HibernateUtil.HibernateUtil;
import com.sai.model.Student;

public class SaveApplication {
	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		boolean flag=false;
		
		try {
			session = HibernateUtil.getSession();
			if(session != null) {
				transaction = session.beginTransaction();
			}
			if(transaction != null) {
				Student student = new Student();
				student.setId(2);
				student.setName("Manoj");
				student.setAge(24);
				student.setCity("Guntur");
				
				session.save(student);
				flag = true;
			}
			
		}catch(HibernateException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(flag) {
				transaction.commit();
				System.out.println("transaction committed and object saved into table");
			}else {
				transaction.rollback();
				System.out.println("transaction failed and object is not saved into table");
			}
			HibernateUtil.closeSession(session);
		}
	}
}
