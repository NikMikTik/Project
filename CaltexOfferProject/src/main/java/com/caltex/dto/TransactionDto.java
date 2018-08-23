package com.caltex.dto;

import java.util.Date;

public class TransactionDto {
	private long transactionId;
	private String transactionType;
	private Date firstTransaction;
	private Date latestTransaction;
	private int totalTransactions=1;
	
	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Date getFirstTransaction() {
		return firstTransaction;
	}

	public void setFirstTransaction(Date firstTransaction) {
		this.firstTransaction = firstTransaction;
	}

	public Date getLatestTransaction() {
		return latestTransaction;
	}

	public void setLatestTransaction(Date latestTransaction) {
		this.latestTransaction = latestTransaction;
	}

	public int getTotalTransactions() {
		return totalTransactions;
	}

	public void setTotalTransactions(int totalTransactions) {
		this.totalTransactions = totalTransactions;
	}
	

}
