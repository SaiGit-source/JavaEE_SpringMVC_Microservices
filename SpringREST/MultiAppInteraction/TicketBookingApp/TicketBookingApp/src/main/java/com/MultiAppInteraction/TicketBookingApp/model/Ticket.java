package com.MultiAppInteraction.TicketBookingApp.model;

import java.time.LocalDate;
// this class is to respond back to client via API

public class Ticket {
	
	private Integer ticketNumber;
	private String ticketStatus;
	private Double ticketPrice;
	
	private String pname;
	private String pdeparture;
	private String parrival;
	private LocalDate pdateOfJourney;
	public Integer getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(Integer ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public String getTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	public Double getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(Double ticketPrice) {
		this.ticketPrice = ticketPrice;
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
	public Ticket(Integer ticketNumber, String ticketStatus, Double ticketPrice, String pname,
			String pdeparture, String parrival, LocalDate pdateOfJourney) {
		super();
		this.ticketNumber = ticketNumber;
		this.ticketStatus = ticketStatus;
		this.ticketPrice = ticketPrice;
		this.pname = pname;
		this.pdeparture = pdeparture;
		this.parrival = parrival;
		this.pdateOfJourney = pdateOfJourney;
	}
	public Ticket() {
		super();
	}
	@Override
	public String toString() {
		return "Ticket [ticketNumber=" + ticketNumber + ", ticketStatus=" + ticketStatus + ", ticketPrice="
				+ ticketPrice + ", pname=" + pname + ", pdeparture=" + pdeparture + ", parrival="
				+ parrival + ", pdateOfJourney=" + pdateOfJourney + "]";
	}

	
}
