package com.sai.model;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class CardPayment extends Payment implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long cardNo;
	private String cardType;
	private String paymentGateway;
	public long getCardNo() {
		return cardNo;
	}
	public void setCardNo(long cardNo) {
		this.cardNo = cardNo;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getPaymentGateway() {
		return paymentGateway;
	}
	public void setPaymentGateway(String paymentGateway) {
		this.paymentGateway = paymentGateway;
	}
	@Override
	public String toString() {
		return "CardPayment [cardNo=" + cardNo + ", cardType=" + cardType + ", paymentGateway=" + paymentGateway + "]";
	}
	
	
}
