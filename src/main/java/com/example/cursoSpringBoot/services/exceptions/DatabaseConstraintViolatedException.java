package com.example.cursoSpringBoot.services.exceptions;

public class DatabaseConstraintViolatedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DatabaseConstraintViolatedException(String message) {
		super(message);
		
	}
	

}
