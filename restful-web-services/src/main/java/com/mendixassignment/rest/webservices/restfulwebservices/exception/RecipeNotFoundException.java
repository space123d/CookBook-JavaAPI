package com.mendixassignment.rest.webservices.restfulwebservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) 
public class RecipeNotFoundException extends RuntimeException {

	public RecipeNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	
}

