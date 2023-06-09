package com.sai.service;



import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sai.HibernateUtil.HibernateUtil;
import com.sai.model.Employee;


public class InsertRecord {
	public static void main(String[] args) {
		Session session = null;	
		Transaction transaction =null;
		boolean flag=false;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			Employee emp = new Employee();
			emp.setEid(10);
			emp.setEaddress("MI");
			emp.setEname("Hari");

			emp.setFriendList(List.of("sai", "manoj", "vamsi"));
			emp.setPhones(Set.of(99988877L,777666777L,555666777L));
			emp.setBankAccounts(Map.of("SBI",112233L,"HDFC",223344L,"ICICI",112244L));

			session.save(emp);
			
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
