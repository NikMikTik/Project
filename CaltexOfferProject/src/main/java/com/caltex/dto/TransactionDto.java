package com.caltex.dto;

import java.time.LocalDateTime;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TransactionDto {
	private long transactionId;
	private String transactionType = "Simple";
	private String serviceName = "Oil Fillup";
	private LocalDateTime firstTransaction;
	private LocalDateTime latestTransaction;
	private float cashback=40f;
	private String cashbackStatus="Not Offered"; 
	@NotNull
	private int totalTransactions = 1;

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

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public LocalDateTime getFirstTransaction() {
		return firstTransaction;
	}

	public void setFirstTransaction(LocalDateTime firstTransaction) {
		this.firstTransaction = firstTransaction;
	}

	public LocalDateTime getLatestTransaction() {
		return latestTransaction;
	}

	public void setLatestTransaction(LocalDateTime latestTransaction) {
		this.latestTransaction = latestTransaction;
	}

	public int getTotalTransactions() {
		return totalTransactions;
	}

	public void setTotalTransactions(int totalTransactions) {
		this.totalTransactions = totalTransactions;
	}

	public float getCashback() {
		return cashback;
	}

	public void setCashback(float cashback) {
		this.cashback = cashback;
	}

	public String getCashbackStatus() {
		return cashbackStatus;
	}

	public void setCashbackStatus(String cashbackStatus) {
		this.cashbackStatus = cashbackStatus;
	}

}
