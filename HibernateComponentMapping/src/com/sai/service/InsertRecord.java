package com.sai.service;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sai.HibernateUtil.HibernateUtil;
import com.sai.model.Student;
import com.sai.model.Address;

public class InsertRecord {
	public static void main(String[] args) {
		Session session = null;	
		Transaction transaction =null;
		boolean flag=false;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			Address address1 = new Address();
			address1.setCity("guntur");
			address1.setState("AP");
			address1.setCountry("India");
			
			Address address2 = new Address();
			address2.setCity("Tenali");
			address2.setState("AP");
			address2.setCountry("India");
			
			Address address3 = new Address();
			address3.setCity("Macharla");
			address3.setState("AP");
			address3.setCountry("India");
			
			Student std1 = new Student();
			Student std2 = new Student();
			Student std3 = new Student();
			std1.setName("sai");
			std1.setAge(24);
			std1.setAddress(address1);
			std2.setName("manoj");
			std2.setAge(22);
			std2.setAddress(address2);
			std3.setName("vamsi");
			std3.setAge(23);
			std3.setAddress(address3);
			
			session.save(std1);
			session.save(std2);
			session.save(std3);

			flag=true;
			
		}catch(HibernateException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(flag)
				transaction.commit();
			else
				transaction.rollback();
			HibernateUtil.closeSession(session);
		}
	}
}
