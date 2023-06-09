package com.sai.service;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sai.HibernateUtil.HibernateUtil;
import com.sai.model.Students;

import java.io.File;
import java.io.FileReader;
import java.io.FileInputStream;

public class SaveApplication {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		boolean flag=false;
		Integer id = null;
		byte[] photo = null;
		char[] resume = null;
		
		try {
			@SuppressWarnings("resource")
			FileInputStream fis = new FileInputStream("C:/Users/krish/Desktop/mypic.jpeg");
			photo = new byte[fis.available()];
			fis.read(photo);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			File f = new File("C:/Users/krish/Desktop/hari.txt");
			@SuppressWarnings("resource")
			FileReader fr = new FileReader(f);
			resume = new char[(int) f.length()];
			fr.read(resume);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			session = HibernateUtil.getSession();
			if(session != null) {
				transaction = session.beginTransaction();
			}
			if(transaction != null) {
				Students student = new Students();
				student.setName("Manoj");
				student.setAge(22);
				student.setCity("Tenali");
				student.setPhoto(photo);
				student.setResume(resume);
				id = (Integer) session.save(student);
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
			}else {
				transaction.rollback();
				System.out.println("Insertion Failed...");
			}
			HibernateUtil.closeSession(session);
		}
	}
}
