package com.caltex.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Transaction_table")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	public int getTotalTransactions() {
		return totalTransactions;
	}

	public void setTotalTransactions(int totalTransactions) {
		this.totalTransactions = totalTransactions;
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

	

	public Transaction(long transactionId, String transactionType, String serviceName, LocalDateTime firstTransaction,
			LocalDateTime latestTransaction, float cashback, String cashbackStatus, @NotNull int totalTransactions) {
		super();
		this.transactionId = transactionId;
		this.transactionType = transactionType;
		this.serviceName = serviceName;
		this.firstTransaction = firstTransaction;
		this.latestTransaction = latestTransaction;
		this.cashback = cashback;
		this.cashbackStatus = cashbackStatus;
		this.totalTransactions = totalTransactions;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionType=" + transactionType + ", serviceName="
				+ serviceName + ", firstTransaction=" + firstTransaction + ", latestTransaction=" + latestTransaction
				+ ", cashback=" + cashback + ", cashbackStatus=" + cashbackStatus + ", totalTransactions="
				+ totalTransactions + "]";
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

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

}
