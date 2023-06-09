package com.sai.service;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sai.HibernateUtil.HibernateUtil;
import com.sai.HibernateUtil.HibernateUtil2ndDB;
import com.sai.model.Students;

public class SaveApplication {

	public static void main(String[] args) {
		Session db1Session = null;
		Session db2Session = null;
		Integer insertedId = null;
		Boolean flag = false;
		Integer id = 1;
		Transaction transaction = null;
		
		try {
			db1Session = HibernateUtil.getSession();
			db2Session = HibernateUtil2ndDB.getSession();
			Students std = db1Session.get(Students.class,id);
			transaction = db2Session.beginTransaction();
			if(std != null) {
				insertedId = (Integer) db2Session.save(std);
				flag = true;
			}else {
				System.out.println("Record not found in DB-1 Students table for id: "+id);
			}
		}catch(HibernateException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(flag) {
				transaction.commit();
				System.out.println("Student record inserted into DB-2 Students table for id:: "+insertedId);
			}else {
				transaction.rollback();
				System.out.println("Insertion Failed...");
			}
			HibernateUtil.closeSession(db1Session);
			HibernateUtil2ndDB.closeSession(db2Session);
		}
	}
}
