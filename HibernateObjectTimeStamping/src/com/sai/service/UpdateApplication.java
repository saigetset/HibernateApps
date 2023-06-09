package com.sai.service;


import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sai.HibernateUtil.HibernateUtil;
import com.sai.model.Students;

public class UpdateApplication {

	public static void main(String[] args) throws IOException {
		Session session = null;
		Transaction transaction = null;
		Students std = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();
			if (session != null) {
				transaction = session.beginTransaction();
				std = session.get(Students.class,1);
			}
			if (transaction != null) {
				std.setCity("cpt");
				flag = true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Student record updated successfully");
				System.out.println(std);
			} else {
				transaction.rollback();
				System.out.println("Updation failed");
			}
		}
	}
}
