package com.MultiAppInteraction.TicketBookingApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
//@OpenAPIDefinition() is for Swagger
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication
@OpenAPIDefinition(
		info=@Info(
				title="TicketBooking API",
				version="v1.0",
				description="This API will Book and Generate full ticket"
				),
		servers=@Server(
				url="http://localhost:8788/TicketBookingAPI",
				description="APIs are deployed in this url"
				)
		)
public class TicketBookingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketBookingAppApplication.class, args);
	}

}
