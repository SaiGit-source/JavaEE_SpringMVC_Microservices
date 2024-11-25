package com.MultiAppInteraction.TicketBookingApp.service;

import org.springframework.stereotype.Service;

import com.MultiAppInteraction.TicketBookingApp.exception.TicketIDNotFoundException;
import com.MultiAppInteraction.TicketBookingApp.model.Passenger;

@Service
public interface ITicketService {
	
	public Passenger registerPassenger(Passenger passenger) throws Exception;
	public Passenger fetchPassengerRecord(Integer pid) throws TicketIDNotFoundException;
	public String deletePassenger(Integer pid) throws TicketIDNotFoundException;
	

}
