package com.Kafka.Publisher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Kafka.Publisher.model.Customer;
import com.Kafka.Publisher.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	// to run -> Start Zookeeper, Kafka
	// zookeeper-server-start.bat zookeeper.properties
	// kafka-server-start.bat kafka.properties
	// start PublisherApplication -> run as Java application
	// Postman: POST: http://localhost:8080/addCx
	/* Body
	 * {
    "id": 1,
    "name": "Abc",
    "city": "Brooklyn"
	}
	 */
	
	// Output: Customer Data Added into Kafka Server
	
	// Run SubscriberApplication as well -> Run As Java Application
	// check the terminal console
	/*
	 * 2024-12-30T22:41:35.281-05:00  INFO 20252 --- [Subscriber] [ntainer#0-0-C-1] o.s.k.l.KafkaMessageListenerContainer    : group_kafka_customer: partitions assigned: [kafka-topic-0]
	 * Msg Recieved From Kafka server* :: {"id":1,"name":"Abc","city":"Brooklyn"}
	 */
	
	@PostMapping("/addCx")
	public ResponseEntity<?> addCxMessage(@RequestBody Customer cx){
		String status=service.addCxMessage(cx);
		return new ResponseEntity<String>(status, HttpStatus.OK);
	}
	
}
