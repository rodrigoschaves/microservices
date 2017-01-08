package com.rodrigoschaves.services.account.domain;

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
public class Account extends ResourceSupport {

	@Id
	private ObjectId id;

	@JsonProperty("account_id")
	private String accountId;

	@JsonProperty("user_id")
	private String userId;

	private Date creationDate;

	private Double amount;

	@JsonProperty("currency_code")
	private String currencyCode;

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public Double getAmount() {
		return amount;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
