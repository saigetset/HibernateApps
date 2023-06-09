package com.sai.Application;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.sai.HibernateUtil.HibernateUtil;
import com.sai.dto.Students;

public class LoadApplication {

	public static void main(String[] args) {
		Session session = null;
		Students std = null;
		int id=10;
		try {
			session = HibernateUtil.getSession();
			std = session.load(Students.class, id);// if id  not found, then exception			
			if(std != null) {
				System.out.println(std);
				System.out.println("This student record is retrieved using Student Obj id:: "+std.hashCode());
			}else {
				System.out.println("Record Not Found..");				
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSession(session);
		}
	}

}
