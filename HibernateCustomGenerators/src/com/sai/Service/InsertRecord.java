package com.sai.Service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sai.dto.Students;
import com.sai.util.HibernateUtil;

public class InsertRecord {
	private static Session session = null;
	private static Transaction transaction = null;
	private static String id = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean flag=false;
		try {
			session = HibernateUtil.getSession();
			if(session!=null)
				transaction = session.beginTransaction();
			if(transaction!=null) {
				Students std = new Students();
				std.setAge(24);
				std.setName("Manoj");
				std.setCity("Tenali");
				id = (String) session.save(std);
				flag = true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(flag) {
				transaction.commit();
				System.out.println("Record inserted successfully for id:: "+id);
			}
			else {
				transaction.rollback();
				System.out.println("Insertion Failed");
			}
			HibernateUtil.closeSession(session);
		}
	}
}
