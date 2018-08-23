package com.caltex.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Transaction_table")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long transactionId;
	private String transactionType = "Simple";
	private Date firstTransaction;
	private Date latestTransaction;
	private int totalTransactions;

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

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionType=" + transactionType
				+ ", firstTransaction=" + firstTransaction + ", latestTransaction=" + latestTransaction
				+ ", totalTransactions=" + totalTransactions + "]";
	}

	public Transaction(long transactionId, String transactionType, Date firstTransaction, Date latestTransaction,
			int totalTransactions) {
		super();
		this.transactionId = transactionId;
		this.transactionType = transactionType;
		this.firstTransaction = firstTransaction;
		this.latestTransaction = latestTransaction;
		this.totalTransactions = totalTransactions;
	}

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

}
