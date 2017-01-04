package com.firstdata.ach.connectpay.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class EstablishRequest {

	@JsonProperty("subscrId")
	String subscrId;

	@JsonProperty("callType")
	String callType;

	@JsonProperty("returnUrl")
	String returnUrl;

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	public String getCallType() {
		return callType;
	}

	public void setCallType(String callType) {
		this.callType = callType;
	}

	public String getSubscrIdl() {
		return subscrId;
	}

	public void setSubscrId(String subscrId) {
		this.subscrId = subscrId;
	}




	
	
}
