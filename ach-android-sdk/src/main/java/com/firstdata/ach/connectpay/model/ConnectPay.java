package com.firstdata.ach.connectpay.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConnectPay {

	@JsonProperty("token")
	private String token;
	
	@JsonProperty("merchant_id")
	private String merchantId;
	
	@JsonProperty("merchant_id_type")
	private String merchantIdType;
	
	@JsonProperty("terminal_id")
	private String terminalId;

	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getMerchantIdType() {
		return merchantIdType;
	}

	public void setMerchantIdType(String merchantIdType) {
		this.merchantIdType = merchantIdType;
	}

	public String getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}
	
	
	
	
}
