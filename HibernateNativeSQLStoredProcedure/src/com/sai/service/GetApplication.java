package com.sai.service;



import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.procedure.ProcedureCall;

import com.sai.HibernateUtil.HibernateUtil;
import com.sai.model.Students;


/**
 * 
 * @author krish
 * 
 * CREATE PROCEDURE P_GET_STUDENT_BY_ID(IN sid INT)
	BEGIN
    	select id,name,age,city from Students where id=sid;
	END //

 */
public class GetApplication {
	@SuppressWarnings({"null", "unchecked" })
	public static void main(String[] args) {
		Session session = null;	
		
		try {
			session = HibernateUtil.getSession();
			ProcedureCall call = session.createStoredProcedureCall("P_GET_STUDENT_BY_ID",Students.class);
			call.registerParameter(1, Integer.class, ParameterMode.IN).bindValue(3);
			List<Students> list = call.getResultList();
			list.forEach(System.out::println);
			/*
			 * list.forEach(row->{ for(Object obj:row) System.out.print(obj+" ");
			 * System.out.println(); });
			 */
		}catch(HibernateException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSession(session);
		}
	}
}
