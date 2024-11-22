package com.springrest.AOP.GlobalExHandling.advice;

import java.time.LocalDateTime;

// what keys do you want to have in error message
// statusCode, exceptionmessage, dateTime

public class ErrorMessage {
	public String statusCode;
	public String exceptionMsg;
	public LocalDateTime dateTime;
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getExceptionMsg() {
		return exceptionMsg;
	}
	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public ErrorMessage(String statusCode, String exceptionMsg, LocalDateTime dateTime) {
		super();
		this.statusCode = statusCode;
		this.exceptionMsg = exceptionMsg;
		this.dateTime = dateTime;
	}
	public ErrorMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ErrorMessage [statusCode=" + statusCode + ", exceptionMsg=" + exceptionMsg + ", dateTime=" + dateTime
				+ "]";
	}
	

}
