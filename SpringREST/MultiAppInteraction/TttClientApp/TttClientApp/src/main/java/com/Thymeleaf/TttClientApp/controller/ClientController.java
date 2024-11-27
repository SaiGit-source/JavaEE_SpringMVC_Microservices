package com.Thymeleaf.TttClientApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.Thymeleaf.TttClientApp.model.Passenger;
import com.Thymeleaf.TttClientApp.model.Ticket;
import com.Thymeleaf.TttClientApp.service.IClientService;

/*
 * WebClient
block() means webclient will act as Synchronous that means thread will wait. But if you use Subscribe it is Asynchronous communication that means thread will not wait
RestTemplate is only for Synchronous communication
Synchronous communication is used for dependent APIs for eg: Bank balance API and Withdraw API,  Asynchronous communication is used for non-dependent APIs eg: Emp info API and Payroll API
 */

// http://localhost:8787/ClientApp/ClientHomePage

@Controller // not a RestController
public class ClientController {
	@Autowired
	private IClientService service;
	
	//Step1: Customer fillout the form
	@GetMapping("/ClientHomePage")
	public String getCustomerInfo(@ModelAttribute("passengerKey") Passenger passenger, Model model) {
		// all these controller methods should point to html pages so return is String
		model.addAttribute("passengerKey", new Passenger()); // empty object because we use the same form for two-way binding during ticketNumber response
		return "passenger-form";
	}

	//Step2: Customer hits submit button
	// once client submits the form, it returns ticketNumber	
	@PostMapping("/BookTicket")
	public String registerCustomer(@ModelAttribute("passengerKey") Passenger passenger, Model model) {
		//two-way binding of Passenger obj
		//instead of @RequestBody we are using two-way binding
		String ticketStatus = service.registerCustomer(passenger); // it talks to the other API and brings back ttNumber
		model.addAttribute("ticketKey", ticketStatus); //we are attaching ticketKey to the same form
		return "passenger-form";
	}
	
	//Step3: Client clicks full-ticket link and enters ttNumber to retrieve ticket
	@GetMapping("/getTicketInfo")
	public String getTicketInfo(Model model) {
		model.addAttribute("ttNumKey", 123);
		return "ticket-form";
	}
	
	//Step4: Client hits submit button in the ticket form
	@PostMapping("/retriveFullTicket")
	public String getFullTicket(@RequestParam("ttNumKey")Integer ticketNumber, Model model) {
		System.out.println(ticketNumber);
		Ticket ticket = service.getFullTicket(ticketNumber);
		model.addAttribute("ttKey", ticket);
		return "full-ticket";
	}
	
	//Step5: Client cancels booking if required
	@GetMapping("/deleteTicket")
	public String deleteBooking(@RequestParam("ttNumKey")Integer ticketNumber, Model model) {
		String status = service.cancelBooking(ticketNumber);
		model.addAttribute("cancelKey", status);
		return "cancel-response";
	}
}
