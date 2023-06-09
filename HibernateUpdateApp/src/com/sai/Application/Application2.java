package com.sai.Application;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sai.HibernateUtil.HibernateUtil;
import com.sai.dto.Students;

public class Application2 {

	public static void main(String[] args) throws IOException {
		Session session = null;
		Transaction transaction = null;
		Students std = null;
		int id = 21;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();
			if (session != null) {
				std = session.get(Students.class, id);
				transaction = session.beginTransaction();
			}
			if (transaction != null) {
				std.setCity("Guntur");
				session.update(std);
				flag = true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				System.in.read();
				transaction.commit();
				System.out.println("Student record updated successfully");
			} else {
				transaction.rollback();
				System.out.println("Updation failed");
			}
		}
	}
}
