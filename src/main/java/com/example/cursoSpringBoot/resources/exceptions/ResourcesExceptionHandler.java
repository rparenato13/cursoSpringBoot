package com.example.cursoSpringBoot.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.cursoSpringBoot.services.exceptions.DatabaseConstraintViolatedException;
import com.example.cursoSpringBoot.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourcesExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request ) {
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(
				Instant.now(), 
				status.value(),
				error,
				e.getMessage(),
				e.getCause() != null ? e.getCause().getMessage() : "" ,
				request.getRequestURI()
				);
		return ResponseEntity.status(status).body(err);
	}
	
	/**
	 * Método para substituir a exceção emitida pelo BD e trabalha para que seja diferente do ERRO 500.
	 * 
	 * @param e
	 * @param request
	 * @return
	 */
	
	@ExceptionHandler(DatabaseConstraintViolatedException.class)
	public ResponseEntity<StandardError> databaseConstraintViolated(DatabaseConstraintViolatedException e, HttpServletRequest request ) {
		String error = "Could not execute statement";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(
				Instant.now(), 
				status.value(),
				error,
				e.getMessage(),
				e.getCause() != null ? e.getCause().getMessage() : "" ,
				request.getRequestURI()
				);
		return ResponseEntity.status(status).body(err);
	}
	
	/**
	 * Método que captura a exceção emitida pelo BD de dados e trabalha para que ela possua um erro diferente do 500 e seja apropriada para o REST.
	 * @param e
	 * @param request
	 * @return
	 */
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandardError> dataIntegrityViolationException(DataIntegrityViolationException e, HttpServletRequest request ) {
		String error = "Could not execute statement extends da própria exceção";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(
				Instant.now(), 
				status.value(),
				error,
				e.getMessage(),
				e.getCause() != null ? e.getCause().getMessage() : "" ,
				request.getRequestURI()
				);
		return ResponseEntity.status(status).body(err);
	}
	
}
