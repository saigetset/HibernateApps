package com.sai.model;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue("cheque")
@PrimaryKeyJoinColumn(name="payment_id",referencedColumnName="paymentId")
public class ChequePayment extends Payment {
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
