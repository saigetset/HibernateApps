package com.sai.service;


import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.sai.HibernateUtil.HibernateUtil;
import com.sai.model.Students;

public class GetApplication {

	public static void main(String[] args) {
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			if(session!=null) {
				Students std1 = session.get(Students.class,1);
				System.out.println("1:: "+std1);
				System.out.println("------------------------");//gets from DB put in L1-cache

				Students std2 = session.get(Students.class,1);
				System.out.println("2:: "+std2);
				System.out.println("------------------------");//gets from L1-cache
				
				session.evict(std1);//Remove std1 object from L1-cache
				
				Students std3 = session.get(Students.class,1);
				System.out.println("3:: "+std3);
				System.out.println("------------------------");//gets from DB put in L1-cache
				
				Students std4 = session.get(Students.class,1);
				System.out.println("4:: "+std4);
				System.out.println("------------------------");//gets from L1-cache
				
				Students std5 = session.get(Students.class,2);
				System.out.println("5:: "+std5);
				System.out.println("------------------------");//gets from DB put in L1-cache
				
				session.clear();//remove all objects from the cache
				
				Students std6 = session.get(Students.class,1);
				System.out.println("6:: "+std6);
				System.out.println("------------------------");//gets from DB and put it in L1-cache
				
				Students std7 = session.get(Students.class,2);
				System.out.println("7:: "+std7);
				System.out.println("------------------------");//gets from DB put it in L1-cache
				
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSession(session);
		}
	}
}
