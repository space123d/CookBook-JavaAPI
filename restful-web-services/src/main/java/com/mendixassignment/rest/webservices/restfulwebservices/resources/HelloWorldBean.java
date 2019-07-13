package com.mendixassignment.rest.webservices.restfulwebservices.resources;

public class HelloWorldBean {

	private String message;

	public HelloWorldBean(String message) {
		this.message= message;
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return String.format("HelloWorldBean [message=%s]", message);
	}

}
