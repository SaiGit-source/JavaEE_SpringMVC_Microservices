package com.Thymeleaf.TttClientApp.service;

import org.springframework.stereotype.Service;

import com.Thymeleaf.TttClientApp.model.Passenger;
import com.Thymeleaf.TttClientApp.model.Ticket;

@Service
public interface IClientService {
	
	public String registerCustomer(Passenger passenger);
	public Ticket getFullTicket(Integer ticketNumber);
	public String cancelBooking(Integer ticketNumber);

}
