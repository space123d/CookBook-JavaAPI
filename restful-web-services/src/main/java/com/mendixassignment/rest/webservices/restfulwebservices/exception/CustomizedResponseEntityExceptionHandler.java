package com.mendixassignment.rest.webservices.restfulwebservices.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@SuppressWarnings({"unchecked","rawtypes"})
@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
	ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),HttpStatus.INTERNAL_SERVER_ERROR,ex.getLocalizedMessage() ,ex.getMessage(),request.getDescription(false));
	return new ResponseEntity<Object>(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(RecipeNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(RecipeNotFoundException ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),HttpStatus.NOT_FOUND,ex.getLocalizedMessage(),ex.getMessage(),request.getDescription(false));
	return new ResponseEntity<Object>(exceptionResponse,HttpStatus.NOT_FOUND);
	}	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),HttpStatus.BAD_REQUEST,ex.getLocalizedMessage(),"Validation Failed",ex.getBindingResult().toString());
	return new ResponseEntity(exceptionResponse,HttpStatus.BAD_REQUEST);
	}
	
	
}
