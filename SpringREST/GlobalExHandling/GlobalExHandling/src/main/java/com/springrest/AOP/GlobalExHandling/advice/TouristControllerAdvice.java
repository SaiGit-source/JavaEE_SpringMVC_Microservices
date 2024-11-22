package com.springrest.AOP.GlobalExHandling.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.springrest.AOP.GlobalExHandling.exception.TouristNotFoundException;

@RestControllerAdvice
public class TouristControllerAdvice {
	// this exception handler handles TouristNotFoundException, that means whenever RestController gets this exception, this guy handles that exception
	@ExceptionHandler(TouristNotFoundException.class)
	public ResponseEntity<?> handleTouristException(TouristNotFoundException tnf){
		ErrorMessage errorMsg = new ErrorMessage("404 not found", tnf.getMessage(), LocalDateTime.now());
		return new ResponseEntity<ErrorMessage>(errorMsg, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGeneralException(Exception e){
		ErrorMessage errorMsg = new ErrorMessage("404 not found", e.getMessage(), LocalDateTime.now());
		return new ResponseEntity<ErrorMessage>(errorMsg, HttpStatus.INTERNAL_SERVER_ERROR);
	}


}
