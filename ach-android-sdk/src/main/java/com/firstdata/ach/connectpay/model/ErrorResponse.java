package com.firstdata.ach.connectpay.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorResponse extends Throwable {
    @JsonProperty("ReturnCode")
    private String returnCode;

    @JsonProperty("Error")
    private String error;

    public String getReturnCode() {
        return returnCode;
    }
    public void setReturnCode(String ReturnCode) {
        this.returnCode = returnCode;
    }

    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }

    @JsonProperty("errorMessages")
    private List<ErrorMessage> errorMessages;
    public List<ErrorMessage> getErrorMessages() {
        return errorMessages;
    }
    public void setErrorMessages(List<ErrorMessage> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public boolean hasErrors() {
        return this.errorMessages != null && this.errorMessages.size() > 0;
    }

    public static class ErrorMessage {

        @JsonProperty("description")
        private String message;

        @JsonProperty("status_code")
        private String statusCode;

        @JsonProperty("status_description")
        private String statusDescription;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(String statusCode) {
            this.statusCode = statusCode;
        }

        public String getStatusDescription() {
            return statusDescription;
        }

        public void setStatusDescription(String statusDescription) {
            this.statusDescription = statusDescription;
        }

    }



}
