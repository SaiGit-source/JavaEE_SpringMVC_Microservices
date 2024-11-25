package com.MultiAppInteraction.TicketBookingApp.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.MultiAppInteraction.TicketBookingApp.exception.TicketIDNotFoundException;

import java.io.IOException;
import java.time.LocalDateTime;

@RestControllerAdvice
public class TicketControllerAdvice {
	
	@ExceptionHandler(TicketIDNotFoundException.class)
	public ResponseEntity<?> handleTicketIDException(TicketIDNotFoundException tnf){
		ErrorMsg error = new ErrorMsg("404 not found", tnf.getMessage(), LocalDateTime.now());
		return new ResponseEntity<ErrorMsg>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGeneralException(Exception e){
		ErrorMsg error = new ErrorMsg("404 not found", e.getMessage(), LocalDateTime.now());
		return new ResponseEntity<ErrorMsg>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(IOException.class)
	public ResponseEntity<?> handleTicketIDException(IOException io){
		ErrorMsg error = new ErrorMsg("404 not found", io.getMessage(), LocalDateTime.now());
		return new ResponseEntity<ErrorMsg>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
