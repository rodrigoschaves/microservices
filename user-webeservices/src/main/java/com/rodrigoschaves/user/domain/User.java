package com.rodrigoschaves.user.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.hateoas.ResourceSupport;

import java.io.Serializable;

/**
 * Created by rodrigo on 04/01/2017.
 */
@Document
public class User extends ResourceSupport {

	@Id
	private ObjectId id;

	@JsonProperty("user_id")
	private String userId;

	@JsonProperty("user_name")
	private String username;

	private boolean enabled;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}
}
