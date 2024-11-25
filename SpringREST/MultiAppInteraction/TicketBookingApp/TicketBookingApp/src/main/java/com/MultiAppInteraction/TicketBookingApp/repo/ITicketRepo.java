package com.MultiAppInteraction.TicketBookingApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MultiAppInteraction.TicketBookingApp.model.Passenger;

// internally to this app, Passenger class is only talking to database

@Repository
public interface ITicketRepo extends JpaRepository<Passenger, Integer> {

}
