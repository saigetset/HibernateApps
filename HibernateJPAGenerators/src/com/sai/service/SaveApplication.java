package com.sai.service;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sai.HibernateUtil.HibernateUtil;
import com.sai.model.Students;

public class SaveApplication {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		boolean flag=false;
		Integer id = null;
		
		try {
			session = HibernateUtil.getSession();
			if(session != null) {
				transaction = session.beginTransaction();
			}
			if(transaction != null) {
				Students student = new Students();
				student.setName("Manoj");
				student.setAge(24);
				student.setCity("Guntur");
				
				id = (Integer) session.save(student);
				flag = true;
			}
			
		}catch(HibernateException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(flag) {
				transaction.commit();
				System.out.println("Student record inserted, id:: "+id);
			}else {
				transaction.rollback();
				System.out.println("Insertion Failed...");
			}
			HibernateUtil.closeSession(session);
		}
	}
}
