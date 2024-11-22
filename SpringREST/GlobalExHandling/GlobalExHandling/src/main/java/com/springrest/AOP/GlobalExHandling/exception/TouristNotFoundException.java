package com.springrest.AOP.GlobalExHandling.exception;

public class TouristNotFoundException extends Exception {

	public TouristNotFoundException(String msg) {
		super(msg);
	} // when we receive the 'msg' we are passing to its parent Exception
	
}
