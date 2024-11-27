package com.Thymeleaf.TttClientApp.service;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Thymeleaf.TttClientApp.model.Passenger;
import com.Thymeleaf.TttClientApp.model.Ticket;

/*
 * WebClient
block() means webclient will act as Synchronous that means thread will wait. But if you use Subscribe it is Asynchronous communication that means thread will not wait
RestTemplate is only for Synchronous communication
Synchronous communication is used for dependent APIs for eg: Bank balance API and Withdraw API,  Asynchronous communication is used for non-dependent APIs eg: Emp info API and Payroll API
 */


@Service
public class ClientService implements IClientService {
	
	private String GetTTNumURL = "http://localhost:8788/TicketBookingAPI/api/book-ticket/getTicketNumber";
	private String GetFullTtUrl = "http://localhost:8788/TicketBookingAPI/api/book-ticket/getFullTicket/{ttNum}";
	private String DelUrl = "http://localhost:8788/TicketBookingAPI/api/book-ticket/cancelBooking/{ttNum}";
	@Override
	public String registerCustomer(Passenger passenger) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.postForEntity(GetTTNumURL, passenger, String.class);
		// input params are App API, passenger object and response class String
		String ticketStatus = response.getBody();
		//System.out.println(response);
		return ticketStatus;
	}

	@Override
	public Ticket getFullTicket(Integer ticketNumber) {
		//System.out.println(ticketNumber);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Ticket> response = restTemplate.getForEntity(GetFullTtUrl, Ticket.class, ticketNumber);
		Ticket ticket = response.getBody();
		return ticket;
	}

	@Override
	public String cancelBooking(Integer ticketNumber) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange(DelUrl, HttpMethod.DELETE,null,String.class, ticketNumber);
		//The DelUrl accepts TicketNumber and returns String response
		String status = response.getBody();
		return status;
	}

}
