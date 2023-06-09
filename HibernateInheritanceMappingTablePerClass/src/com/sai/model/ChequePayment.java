package com.sai.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class ChequePayment extends Payment implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long chequeNo;
	private String chequeType;
	private LocalDate expiryDate;
	public long getChequeNo() {
		return chequeNo;
	}
	public void setChequeNo(long chequeNo) {
		this.chequeNo = chequeNo;
	}
	public String getChequeType() {
		return chequeType;
	}
	public void setChequeType(String chequeType) {
		this.chequeType = chequeType;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	@Override
	public String toString() {
		return "ChequePayment [chequeNo=" + chequeNo + ", chequeType=" + chequeType + ", expiryDate=" + expiryDate
				+ "]";
	}
	
	
}
