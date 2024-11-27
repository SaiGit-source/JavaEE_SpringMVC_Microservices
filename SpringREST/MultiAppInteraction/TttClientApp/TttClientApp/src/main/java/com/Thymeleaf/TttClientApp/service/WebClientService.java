package com.Thymeleaf.TttClientApp.service;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.Thymeleaf.TttClientApp.model.Passenger;
import com.Thymeleaf.TttClientApp.model.Ticket;

// Web client Sync communication with block() example
@Service
@Primary
public class WebClientService implements IClientService {

	private String GetTTNumURL = "http://localhost:8788/TicketBookingAPI/api/book-ticket/getTicketNumber";
	private String GetFullTtUrl = "http://localhost:8788/TicketBookingAPI/api/book-ticket/getFullTicket/{ttNum}";
	private String DelUrl = "http://localhost:8788/TicketBookingAPI/api/book-ticket/cancelBooking/{ttNum}";
	@Override
	public String registerCustomer(Passenger passenger) {
		WebClient webClient = WebClient.create();
		String ticketStatus=webClient.post()
		.uri(GetTTNumURL)
		.bodyValue(passenger)
		.retrieve()
		.bodyToMono(String.class)
		.block();
		return ticketStatus;
	}

	@Override
	public Ticket getFullTicket(Integer ticketNumber) {
		WebClient webClient = WebClient.create();
		Ticket ticket = webClient.get()
		.uri(GetFullTtUrl, ticketNumber)
		.retrieve()
		.bodyToMono(Ticket.class)
		.block();
		return ticket;
	}

	@Override
	public String cancelBooking(Integer ticketNumber) {
		WebClient webClient = WebClient.create();
		String delStatus = webClient.delete()
		.uri(DelUrl, ticketNumber)
		.retrieve()
		.bodyToMono(String.class)
		.block();
		return delStatus;
	}

}
