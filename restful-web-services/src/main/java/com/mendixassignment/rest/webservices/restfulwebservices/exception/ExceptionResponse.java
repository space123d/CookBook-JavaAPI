package com.mendixassignment.rest.webservices.restfulwebservices.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ExceptionResponse {

	private Date timestamp;
	private String message;
	private String details;
	private HttpStatus  status;
	private String error;
	
	
	public ExceptionResponse(Date timestamp,HttpStatus status, String error, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
		this.status = status;
		this.error = error;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public String getMessage() {
		return message;
	}
	public String getDetails() {
		return details;
	}
	
	public HttpStatus getStatus() {
		return status;
	}
	public String getError() {
		return error;
	}
	
	
}
