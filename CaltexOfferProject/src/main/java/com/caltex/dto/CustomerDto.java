package com.caltex.dto;

public class CustomerDto {

	private long customerId;
	private String customerType;
	private String customerName;
	private String customerEmail;
	private long customerPhoneNo;
	private TransactionDto transactionDto;

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

	public TransactionDto getTransactionDto() {
		return transactionDto;
	}

	public void setTransactionDto(TransactionDto transactionDto) {
		this.transactionDto = transactionDto;
	}

	

}
