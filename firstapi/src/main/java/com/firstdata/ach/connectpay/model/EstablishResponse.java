package com.firstdata.ach.connectpay.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(getterVisibility=Visibility.NONE,setterVisibility=Visibility.NONE,fieldVisibility=Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_EMPTY)
public class EstablishResponse extends Throwable{


	
	@JsonProperty("accessId")
	private String accessId;
	
	@JsonProperty("merchantId")
	private String merchantId;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("currency")
	private String currency;
	
	@JsonProperty("amount")
	private String amount;
	
	@JsonProperty("paymentType")
	private String paymentType;
	
	@JsonProperty("merchantReference")
	private String merchantReference;
	
	@JsonProperty("requestSignature")
	private String requestSignature;
	
	@JsonProperty("returnUrl")
	private String returnUrl;

	public String getAccessId() {
		return accessId;
	}
	public void setAccessId(String accessId) {
		this.accessId = accessId;
	}

	public String getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}


	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}


	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
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

	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}





}
