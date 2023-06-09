package com.sai.service;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sai.HibernateUtil.HibernateUtil;
import com.sai.model.StudentClassID;
import com.sai.model.Students;

public class SaveApplication {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		boolean flag=false;
		StudentClassID id = null;
		Students std = new Students();
		StudentClassID sc = new StudentClassID();

		try {
			session = HibernateUtil.getSession();
			if(session != null) {
				transaction = session.beginTransaction();
			}
			if(transaction != null) {
				sc.setStudentId(100);
				sc.setClassId(200);
				std.setScid(sc);
				std.setName("Manoj");
				std.setAge(22);
				std.setCity("Tenali");
				
				id = (StudentClassID) session.save(std);
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
				System.out.println(std);
			}else {
				transaction.rollback();
				System.out.println("Insertion Failed...");
			}
			HibernateUtil.closeSession(session);
		}
	}
}
