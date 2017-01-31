package com.firstdata.ach.connectpay.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by Arjun Chinya on 6/12/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TokenErrorResponse extends Throwable {
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

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

    }


}
