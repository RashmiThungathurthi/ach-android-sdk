package com.firstdata.ach.connectpay.model;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonAutoDetect(getterVisibility=Visibility.NONE,setterVisibility=Visibility.NONE,fieldVisibility=Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_EMPTY)
public class TransactionResponse extends Throwable{


	@JsonProperty("transaction_status")
	private String transactionStatus = "Not Processed";
	
    @JsonProperty("correlation_id")
    private String corrID;
	
	@JsonProperty("validation_status")
	private String validationStatus;
	
	@JsonProperty("transaction_type")
	private String transactionType;
	
	@JsonProperty("transaction_id")
	private String transactionId;
	
	@JsonProperty("method")
	private String method;
	
	@JsonProperty("amount")
	private String amount;
	
	@JsonProperty("currency")
	private String currency;
	
    @JsonProperty("gateway_resp_code")
    private String exactResponseCode;
    
    @JsonProperty("gateway_message")
    private String exactMessage;
	
	@JsonProperty("error")
	private String error;

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public String getValidationStatus() {
		return validationStatus;
	}

	public void setValidationStatus(String validationStatus) {
		this.validationStatus = validationStatus;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCorrID() {
		return corrID;
	}

	public void setCorrID(String corrID) {
		this.corrID = corrID;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getExactResponseCode() {
		return exactResponseCode;
	}

	public void setExactResponseCode(String exactResponseCode) {
		this.exactResponseCode = exactResponseCode;
	}

	public String getExactMessage() {
		return exactMessage;
	}

	public void setExactMessage(String exactMessage) {
		this.exactMessage = exactMessage;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	
	
	
	
	
}