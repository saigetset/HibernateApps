package com.sai.service;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sai.HibernateUtil.HibernateUtil;
import com.sai.model.Students;

public class Application1 {

	@SuppressWarnings("null")
	public static void main(String[] args) throws IOException, InterruptedException {
		Session session = null;
		Transaction transaction = null;
		Students std = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			std = session.get(Students.class, 1, LockMode.UPGRADE_NOWAIT);

			Thread.sleep(30000);
			std.setCity("Burma");
			session.update(std);
			flag = true;

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Updated successfully");
			} else {
				transaction.rollback();
				System.out.println("Updation failed");
			}
		}
	}
}
