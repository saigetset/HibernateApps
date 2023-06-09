package com.sai.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.type.StandardBasicTypes;

import com.sai.HibernateUtil.HibernateUtil;
import com.sai.model.Students;

public class InsertApplication {
	@SuppressWarnings({ "deprecation", "unchecked" })
	public static void main(String[] args) {
		Session session = null;	
		Transaction transaction=null;
		boolean flag=false;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			NativeQuery query = session.createSQLQuery("Insert into Students(name,age,city) values(:sname,:sage,:scity)");
			query.setParameter("sname", "Raghu");
			query.setParameter("sage", 24);
			query.setParameter("scity", "guntur");
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
