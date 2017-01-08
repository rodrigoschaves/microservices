package com.rodrigoschaves.services.transaction.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.hateoas.ResourceSupport;

import java.util.Date;

/**
 * Created by rodrigo on 04/01/2017.
 */
@Document
public class Transaction extends ResourceSupport {

	@Id
	private ObjectId transactionId;

	@JsonProperty("account_id")
	private String accountId;

	private Date date;

	private Double amount;

	private String type;

	private String status;

	private String source;

	@JsonProperty("currency_code")
	private String currencyCode;

	public Transaction(String accountId) {
		this.accountId = accountId;
	}

	public ObjectId getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(ObjectId transactionId) {
		this.transactionId = transactionId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
}
