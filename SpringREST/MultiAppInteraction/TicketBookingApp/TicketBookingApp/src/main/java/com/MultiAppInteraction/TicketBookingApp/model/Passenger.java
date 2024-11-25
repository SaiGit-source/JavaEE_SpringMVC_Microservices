package com.MultiAppInteraction.TicketBookingApp.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Passenger {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer pid;
	public String pname;
	public String pdeparture;
	public String parrival;
	public LocalDate pdateOfJourney;
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
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
		this.pid=pid;
		this.pname = pname;
		this.pdeparture = pdeparture;
		this.parrival = parrival;
		this.pdateOfJourney = pdateOfJourney;
	}
	public Passenger() {
		super();
	}
	@Override
	public String toString() {
		return "Passenger [pid=" + pid + ", pname=" + pname + ", pdeparture=" + pdeparture + ", parrival=" + parrival
				+ ", pdateOfJourney=" + pdateOfJourney + "]";
	}
	
}
