package com.sai.service;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import com.sai.HibernateUtil.HibernateUtil;

public class InsertApplication {
	@SuppressWarnings({ "rawtypes" })
	public static void main(String[] args) {
		Session session = null;	
		Transaction transaction=null;
		boolean flag=false;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			NativeQuery query = session.getNamedNativeQuery("STUDENT_INSERT_QUERY");
			query.setParameter("sname", "abhi");
			query.setParameter("sage", 24);
			query.setParameter("scity", "hyd");
			int val = query.executeUpdate();
			if(val == 1) {
				System.out.println("Insertion Successful");
				flag = true;
			}else
				System.out.println("Insertion failed");
			
			
		}catch(HibernateException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(flag){
				transaction.commit();
			}
			else
				transaction.rollback();
			HibernateUtil.closeSession(session);
		}
	}
}
