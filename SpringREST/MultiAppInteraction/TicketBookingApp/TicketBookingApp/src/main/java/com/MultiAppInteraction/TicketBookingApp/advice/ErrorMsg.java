package com.MultiAppInteraction.TicketBookingApp.advice;

import java.time.LocalDateTime;

// Keys in errorMessage: status, message, timestamp

public class ErrorMsg {
	public String status;
	public String msg;
	public LocalDateTime time;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public ErrorMsg(String status, String msg, LocalDateTime time) {
		super();
		this.status = status;
		this.msg = msg;
		this.time = time;
	}
	public ErrorMsg() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ErrorMsg [status=" + status + ", msg=" + msg + ", time=" + time + "]";
	}
	

}
