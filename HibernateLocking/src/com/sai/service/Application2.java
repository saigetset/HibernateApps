package com.sai.service;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sai.HibernateUtil.HibernateUtil;
import com.sai.model.Students;

public class Application2 {
	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		Students std = null;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			std = session.get(Students.class, 1);
			std.setCity("USA");
			session.update(std);
			flag = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Student record updated");
			} else {
				transaction.rollback();
				System.out.println("Updation failed");
			}
			HibernateUtil.closeSession(session);
		}
	}
}
