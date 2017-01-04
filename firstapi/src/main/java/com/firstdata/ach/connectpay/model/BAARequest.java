package com.firstdata.ach.connectpay.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BAARequest {

	
	@JsonProperty("subscriber_id")
	private String subscriberId;
	
	@JsonProperty("token")
	private String token;
	
	@JsonProperty("authentication_answer")
	private int authenticationAnswer;
	

	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getAuthenticationAnswer() {
		return authenticationAnswer;
	}
	public void setAuthenticationAnswer(int authenticationAnswer) {
		this.authenticationAnswer = authenticationAnswer;
	}
	public String getSubscriberId() {
		return subscriberId;
	}
	public void setSubscriberId(String subscriberId) {
		this.subscriberId = subscriberId;
	}
	
	
	
}
