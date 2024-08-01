package com.example.recharge.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cust_table")
public class Customer {

	private int accNo;
	private String custName;
	@Id
	private String emailId;
	private long mobNo;
	private double accBal;
	private String password;
	
	
	public Customer() {}

	public Customer(int accNo, String custName, String emailId, String password, long mobNo, double accBal) {
		super();
		this.accNo = accNo;
		this.custName = custName;
		this.emailId = emailId;
		this.password = password;
		this.mobNo = mobNo;
		this.accBal = accBal;
	}

	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getMobNo() {
		return mobNo;
	}

	public void setMobNo(long mobNo) {
		this.mobNo = mobNo;
	}

	public double getAccBal() {
		return accBal;
	}

	public void setAccBal(double accBal) {
		this.accBal = accBal;
	}

	@Override
	public String toString() {
		return "Customer [accNo=" + accNo + ", custName=" + custName + ", emailId=" + emailId + ", password=" + password
				+ ", mobNo=" + mobNo + ", accBal=" + accBal + "]";
	}

}
