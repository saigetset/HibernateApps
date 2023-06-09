package com.sai.service;


import java.time.LocalDate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sai.HibernateUtil.HibernateUtil;
import com.sai.model.*;



public class InsertRecord {
	public static void main(String[] args) {
		Session session = null;	
		Transaction transaction =null;
		boolean flag=false;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			CardPayment card = new CardPayment();
			card.setPaymentId(1);
			card.setAmount(200);
			card.setCardNo(1234L);
			card.setPaymentGateway("RazorPay");
			card.setCardType("Debit");
			
			ChequePayment cheque = new ChequePayment();
			cheque.setPaymentId(2);
			cheque.setAmount(300);
			cheque.setChequeNo(2345L);
			cheque.setChequeType("deposit");
			cheque.setExpiryDate(LocalDate.now());
			
			session.save(card);
			session.save(cheque);
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
