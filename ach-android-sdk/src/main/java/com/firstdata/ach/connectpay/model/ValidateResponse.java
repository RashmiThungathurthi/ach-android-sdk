package com.firstdata.ach.connectpay.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_EMPTY)
public class ValidateResponse{
	public ValidateResponse(){
		super();
	}

	@JsonProperty("TCKObj")
	private TCKObj tckObj;

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class TCKObj extends Throwable{
		@JsonProperty("transactionId")
		private String transactionId;

		@JsonProperty("name")
		private String name;

		@JsonProperty("phone")
		private String phone;

		@JsonProperty("email")
		private String email;

		@JsonProperty("address1")
		private String address1;

		@JsonProperty("address2")
		private String address2;

		@JsonProperty("city")
		private String city;

		@JsonProperty("zip")
		private String zip;

		@JsonProperty("bank_rt")
		private String bank_rt;

		@JsonProperty("state")
		private String state;

		@JsonProperty("bank_acct")
		private String bank_acct;

		@JsonProperty("error")
		private String error;

		public String getTransactionId() {
			return transactionId;
		}
		public void setTransactionId(String transactionId) {
			this.transactionId = transactionId;
		}

		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}

		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}

		public String getAddress1() {
			return address1;
		}
		public void setAddress1(String address1) {
			this.address1 = address1;
		}

		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}

		public String getAddress2() {
			return address2;
		}
		public void setAddress2(String address2) {
			this.address2 = address2;
		}

		public String getBank_rt() {
			return bank_rt;
		}
		public void setBank_rt(String bank_rt) {
			this.bank_rt = bank_rt;
		}

		public String getZip() {
			return zip;
		}
		public void setZip(String zip) {
			this.zip = zip;
		}

		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}

		public String getBank_acct() {
			return bank_acct;
		}
		public void setBank_acct(String bank_acct) {
			this.bank_acct = bank_acct;
		}

		public String getError() {
			return error;
		}

		public void setError(String error) {
			this.error = error;
		}
	}

	public TCKObj getTckObj() {
		return tckObj;
	}

	public void setTckObj(TCKObj tckObj) {
		this.tckObj = tckObj;
	}
}