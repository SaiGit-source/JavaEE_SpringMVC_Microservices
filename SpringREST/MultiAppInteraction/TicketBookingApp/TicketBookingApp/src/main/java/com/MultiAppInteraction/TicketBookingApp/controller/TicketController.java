package com.MultiAppInteraction.TicketBookingApp.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MultiAppInteraction.TicketBookingApp.exception.TicketIDNotFoundException;
import com.MultiAppInteraction.TicketBookingApp.model.Passenger;
import com.MultiAppInteraction.TicketBookingApp.model.Ticket;
import com.MultiAppInteraction.TicketBookingApp.service.ITicketService;

import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import springfox.documentation.annotations.ApiIgnore;


@RestController
@RequestMapping("/api/book-ticket")
@Tag(name="TicketBookingAPI", description="There are 3 apis: API1 accepts Passenger info and generates TicketNumber, API2 accepts TicketNumber and generates FullTicket, API3 accepts TicketNumber and cancels ticket")
public class TicketController {

	@Autowired
	private ITicketService service;
	
	// enter http://localhost:8788/TicketBookingAPI/api/book-ticket/
	// this is only for Swagger. it will redirect to swagger ui
	// it redirects to http://localhost:8788/TicketBookingAPI/swagger-ui.html
	// this also works: http://localhost:8788/TicketBookingAPI/swagger-ui/index.html#/
	
	@ApiIgnore
	@RequestMapping(value="/")
	public void redirect(HttpServletResponse response) throws IOException {
		response.sendRedirect("/TicketBookingAPI/swagger-ui.html");
	}
	
	// Your TicketNumber is: 352
	@PostMapping("/getTicketNumber") //@RequestBody because we are accepting the entire JSON object converted to Passenger object as opposed to a few variables
	@Operation(summary="POST Operation", description="This API accepts Passenger info and Generates Ticket number") // this info is for developers using this API because those developers dont have access to our code base so they cant read our internal comments
	public ResponseEntity<?> registerPassengerRecord(@RequestBody Passenger passenger) throws Exception{
		System.out.println(passenger.getPname());
		Passenger p = service.registerPassenger(passenger);
		
		Integer ttNumber = p.getPid();
		return new ResponseEntity<String>("Your TicketNumber is: "+ttNumber, HttpStatus.CREATED);
	}
	
	/* if ID not found
	 * {
  		"status": "404 not found",
  		"msg": "Custom exception: TicketNumber 10 not found to fetch",
  		"time": "2024-11-25T01:43:42.8191504"
		}
	 */
	
	@GetMapping("/getFullTicket/{ttNum}")
	@Operation(summary="GET Operation", description="This API accepts TicketNumber and generates full ticket")
	public ResponseEntity<?> retrieveTicket(@PathVariable("ttNum") Integer ttNumber) throws TicketIDNotFoundException{
		Passenger p = service.fetchPassengerRecord(ttNumber); // we are using PassengerID as our TicketNumber
		Ticket tt = new Ticket();
		tt.setPname(p.getPname());
		tt.setTicketNumber(p.getPid());
		tt.setPdeparture(p.getPdeparture());
		tt.setParrival(p.getParrival());
		tt.setPdateOfJourney(p.getPdateOfJourney());
		tt.setTicketStatus("Confirmed");
		tt.setTicketPrice(34923.534);
		return new ResponseEntity<Ticket>(tt, HttpStatus.OK);
	}
	
	// Booking canceled: TicketNumber 2 is deleted
	/* in case of not found
	 * 
	 * {
  		"status": "404 not found",
  		"msg": "Custom exception: TicketNumber 2 not found for deletion",
  		"time": "2024-11-25T01:46:05.0234467"
		}
	 */
	
	@DeleteMapping("/cancelBooking/{ttNum}")
	@Operation(summary="DELETE Operation", description="This API accepts TicketNumber and cancels booking")
	public ResponseEntity<?> cancelTicket(@PathVariable("ttNum") Integer ttNumber) throws TicketIDNotFoundException{
		String status = service.deletePassenger(ttNumber);
		return new ResponseEntity<String>(status, HttpStatus.OK);
	}
	
}
