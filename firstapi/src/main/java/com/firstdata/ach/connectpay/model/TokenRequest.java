package com.firstdata.ach.connectpay.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;


public class TokenRequest {

	@JsonProperty("subscriber_id")
	String subscriberId;
	
	@JsonProperty("transaction_id")
	String pwmbTransactionId; 
	
	@JsonProperty("first_name")
	String firstName;
	
	@JsonProperty("last_name")
	String lastName;
	
	@JsonProperty("additional_phones")
	private ArrayList<Phone> phones;
	
	
	public String getSubscriberId() {
		return subscriberId;
	}
	public void setSubscriberId(String subscriberId) {
		this.subscriberId = subscriberId;
	}
	public String getPwmbTransactionId() {
		return pwmbTransactionId;
	}
	public void setPwmbTransactionId(String pwmbTransactionId) {
		this.pwmbTransactionId = pwmbTransactionId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public ArrayList<Phone> getPhones() {
		return phones;
	}
	public void setPhones(ArrayList<Phone> phones) {
		this.phones = phones;
	}
	
	
	
}
