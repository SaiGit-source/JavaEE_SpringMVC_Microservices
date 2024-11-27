package com.Thymeleaf.TttClientApp.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class Passenger {
	private Integer pid;
	public String pname;
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String pdeparture;
	public String parrival;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public LocalDate pdateOfJourney;
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPdeparture() {
		return pdeparture;
	}
	public void setPdeparture(String pdeparture) {
		this.pdeparture = pdeparture;
	}
	public String getParrival() {
		return parrival;
	}
	public void setParrival(String parrival) {
		this.parrival = parrival;
	}
	public LocalDate getPdateOfJourney() {
		return pdateOfJourney;
	}
	public void setPdateOfJourney(LocalDate pdateOfJourney) {
		this.pdateOfJourney = pdateOfJourney;
	}
	public Passenger(Integer pid, String pname, String pdeparture, String parrival, LocalDate pdateOfJourney) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pdeparture = pdeparture;
		this.parrival = parrival;
		this.pdateOfJourney = pdateOfJourney;
	}
	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Passenger [pid=" + pid + ", pname=" + pname + ", pdeparture=" + pdeparture + ", parrival=" + parrival
				+ ", pdateOfJourney=" + pdateOfJourney + "]";
	}
	

}
