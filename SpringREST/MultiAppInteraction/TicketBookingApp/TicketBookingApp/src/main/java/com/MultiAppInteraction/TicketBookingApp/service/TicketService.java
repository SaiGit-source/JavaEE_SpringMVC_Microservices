package com.MultiAppInteraction.TicketBookingApp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MultiAppInteraction.TicketBookingApp.exception.TicketIDNotFoundException;
import com.MultiAppInteraction.TicketBookingApp.model.Passenger;
import com.MultiAppInteraction.TicketBookingApp.repo.ITicketRepo;

@Service
public class TicketService implements ITicketService {

	@Autowired
	private ITicketRepo repo;
	
	@Override
	public Passenger registerPassenger(Passenger passenger) throws Exception {
		Passenger p1 = repo.save(passenger);
		if (p1!=null) {
			return p1;
		}
		else {
			throw new Exception("General exception: Some error during registering");
		}
	}

	@Override
	public Passenger fetchPassengerRecord(Integer pid) throws TicketIDNotFoundException {
		Optional<Passenger> optional = repo.findById(pid);
		if (optional.isPresent()) {
			return optional.get();
		}
		else {
			throw new TicketIDNotFoundException("Custom exception: TicketNumber "+pid+ " not found to fetch");
		}
		
	}

	@Override
	public String deletePassenger(Integer pid) throws TicketIDNotFoundException {
		Optional<Passenger> optional = repo.findById(pid);
		if (optional.isPresent()) {
			repo.deleteById(pid);
			return "Booking canceled: TicketNumber "+pid+ " is deleted";
		}
		else {
			throw new TicketIDNotFoundException("Custom exception: TicketNumber "+pid+ " not found for deletion");
		}

	}

}
