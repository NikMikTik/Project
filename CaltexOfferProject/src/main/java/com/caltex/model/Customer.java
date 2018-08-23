package com.caltex.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customer_table")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long customerId;
	private String customerType="Active";
	private String customerName;
	private String customerEmail;
	private long customerPhoneNo;
	private Transaction transaction;

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public long getCustomerPhoneNo() {
		return customerPhoneNo;
	}

	public void setCustomerPhoneNo(long customerPhoneNo) {
		this.customerPhoneNo = customerPhoneNo;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerType=" + customerType + ", customerName="
				+ customerName + ", customerEmail=" + customerEmail + ", customerPhoneNo=" + customerPhoneNo
				+ ", transaction=" + transaction + "]";
	}

	public Customer(long customerId, String customerType, String customerName, String customerEmail,
			long customerPhoneNo, Transaction transaction) {
		super();
		this.customerId = customerId;
		this.customerType = customerType;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPhoneNo = customerPhoneNo;
		this.transaction = transaction;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

}
