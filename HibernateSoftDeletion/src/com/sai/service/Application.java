package com.sai.service;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sai.HibernateUtil.HibernateUtil;
import com.sai.model.Students;


public class Application {
	public static void main(String[] args) {
		Session session = null;		
		Transaction transaction =null;
		Boolean flag=false;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			Students std = new Students();
			std.setId(3);
			session.delete(std);
			flag=true;
		}catch(HibernateException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(flag) {
				transaction.commit();
				System.out.println("Deleted Successfully");
			}else {
				transaction.rollback();
				System.out.println("Deletion failed");
			}
			HibernateUtil.closeSession(session);
		}
	}
}
