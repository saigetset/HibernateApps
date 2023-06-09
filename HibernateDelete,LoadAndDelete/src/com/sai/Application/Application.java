package com.sai.Application;


import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sai.HibernateUtil.HibernateUtil;
import com.sai.dto.Students;

public class Application {

	public static void main(String[] args) throws IOException {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		
		try {
			session = HibernateUtil.getSession();
			if(session!=null)
				transaction = session.beginTransaction();
			if(transaction!=null) {	
				Students std = new Students();
				std.setId(99);
				session.delete(std);// would give any exception if id doesn't exist
				flag = true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (flag) {
				transaction.commit();
				System.out.println("Student record deleted successfully");				
			} else {
				transaction.rollback();
				System.out.println("Deletion failed");
			}
		}
	}
}
