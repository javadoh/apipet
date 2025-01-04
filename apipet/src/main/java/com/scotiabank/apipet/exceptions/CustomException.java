package com.scotiabank.apipet.exceptions;

import org.springframework.http.HttpStatusCode;

public class CustomException extends RuntimeException{

    private String message;
    private HttpStatusCode statusCode;

    public CustomException(String message, HttpStatusCode statusCode) {
        super(message);
        this.message = message;
        this.statusCode = statusCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatusCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatusCode statusCode) {
        this.statusCode = statusCode;
    }
}
