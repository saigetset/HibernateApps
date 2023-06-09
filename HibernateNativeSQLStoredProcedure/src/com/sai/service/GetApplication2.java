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
 * CREATE PROCEDURE P_GET_STUDENT_NAME_CITY_BY_ID(IN sid INT,OUT sname varchar(45), OUT scity VARCHAR(45))
	BEGIN
    	select name,city into sname,scity from Students where id=sid;
	END //

 */
public class GetApplication2 {
	@SuppressWarnings({"null", "unchecked" })
	public static void main(String[] args) {
		Session session = null;	
		
		try {
			session = HibernateUtil.getSession();
			ProcedureCall call = session.createStoredProcedureCall("P_GET_STUDENT_NAME_CITY_BY_ID",Students.class);
			call.registerParameter(1, Integer.class, ParameterMode.IN).bindValue(3);
			call.registerParameter(2, String.class, ParameterMode.OUT);
			call.registerParameter(3, String.class, ParameterMode.OUT);
			
			String name = (String) call.getOutputParameterValue(2);
			String city = (String) call.getOutputParameterValue(3);
			System.out.println(name+" "+city);
			
		}catch(HibernateException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSession(session);
		}
	}
}
