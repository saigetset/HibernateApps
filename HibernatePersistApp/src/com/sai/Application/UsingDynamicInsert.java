package com.sai.Application;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sai.HibernateUtil.HibernateUtil;
import com.sai.dto.Student;

public class UsingDynamicInsert {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();

			Student std = new Student();
			std.setId(25);
			std.setAge(22);
			std.setName("ashok");
			session.persist(std);
			flag = true;

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Student record inserted successfully");				
			} else {
				transaction.rollback();
				System.out.println("Insertion failed");
			}
		}
	}
}
