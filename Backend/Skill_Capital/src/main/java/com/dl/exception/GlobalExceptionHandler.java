package com.dl.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
//@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	//If we are finding the id, if the is not matched we use this exception
	@ExceptionHandler(LeadNotFoundException.class)
	public ResponseEntity<?> handleLeadNotFoundException(LeadNotFoundException ex, WebRequest request){
		
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
		
	}
	
	//If we are trying to insert the duplicate email id and contact number greater than 10
	@ExceptionHandler(LeadCreationException.class)
	public ResponseEntity<?> handleLeadNotFoundException(LeadCreationException ex, WebRequest request){
		
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(LeadUpdateException.class)
	public ResponseEntity<?> handleLeadNotFoundException(LeadUpdateException ex, WebRequest request){
		
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		
	}
	
	//If we are trying to insert the duplicate email id
	@ExceptionHandler(InvalidEmailException.class)
	public ResponseEntity<?> handleInvalidEmailException(InvalidEmailException ex, WebRequest request){
		
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		
	}
	
	//If we are trying to insert contact number greater than 10
	@ExceptionHandler(InvalidContactNumberException.class)
	public ResponseEntity<?> handleInvalidContactNumberException(InvalidContactNumberException ex, WebRequest request){
		
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGlobalException(Exception ex, WebRequest request){
		
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
//	//For Validation
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request){
		
		Map<String, String> errors = new HashMap<>();
		List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
		allErrors.forEach((error) ->{
			
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errors.put(fieldName, message);
		});
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
		
		
	}
}