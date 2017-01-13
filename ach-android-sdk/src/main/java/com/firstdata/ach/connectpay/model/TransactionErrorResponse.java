package com.firstdata.ach.connectpay.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by Arjun Chinya on 6/12/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionErrorResponse extends Throwable {

    @JsonProperty("correlation_id")
    private String corelationId;
    @JsonProperty("transaction_status")
    private String transactionStatus;
    @JsonProperty("validation_status")
    private String validationStatus;
    @JsonProperty("transaction_type")
    private String transactionType;
    @JsonProperty("method")
    private String method;
    @JsonProperty("amount")
    private String amount;
    @JsonProperty("currency")
    private String currency;

    @JsonProperty("Error")
    private Error error;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Error {
        @JsonProperty("messages")
        private List<Message> messages;

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Message {
            @JsonProperty("code")
            private String code;
            @JsonProperty("description")
            private String message;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }
        }

        public List<Message> getMessages() {
            return messages;
        }

        public void setMessages(List<Message> messages) {
            this.messages = messages;
        }
    }

    public String getCorelationId() {
        return corelationId;
    }

    public void setCorelationId(String corelationId) {
        this.corelationId = corelationId;
    }

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

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}
