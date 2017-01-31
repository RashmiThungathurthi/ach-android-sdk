package com.firstdata.ach.connectpay.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ValidateRequest {

	@JsonProperty("transactionId")
	private String transactionId;

	@JsonProperty("callType")
	private String callType;

	@JsonProperty("requestSignature")
	private String requestSignature;

	@JsonProperty("transactionType")
	private String transactionType;

	@JsonProperty("merchantReference")
	private String merchantReference;

	@JsonProperty("status")
	private String status;

	@JsonProperty("returnUrl")
	private String returnUrl;

	@JsonProperty("payment.account.verified")
	private String verified;

	@JsonProperty("payment.paymentType")
	private String paymentType;

	@JsonProperty("payment.paymentProvider.type")
	private String type;

	@JsonProperty("panel")
	private String panel;

	public String getVerifiedd() {
		return verified;
	}
	public void setVerified(String verified) {
		this.verified = verified;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getCallType() {
		return callType;
	}
	public void setCallType(String callType) {
		this.callType = callType;
	}

	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}


	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


	public String getPanel() {
		return panel;
	}
	public void setPanel(String panel) {
		this.panel = panel;
	}


	public String getMerchantReference() {
		return merchantReference;
	}
	public void setMerchantReference(String merchantReference) {
		this.merchantReference = merchantReference;
	}

	public String getRequestSignature() {
		return requestSignature;
	}
	public void setRequestSignature(String requestSignature) {
		this.requestSignature = requestSignature;
	}

	public String getReturnUrl() {
		return returnUrl;
	}
	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}


	
	
}
