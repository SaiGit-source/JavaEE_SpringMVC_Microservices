package com.Kafka.Publisher.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.Kafka.Publisher.model.Customer;
import com.Kafka.Publisher.util.AppConstants;

@Service
public class CustomerService {
	
	@Autowired
	private KafkaTemplate<String, Customer> kafkaTemplate;
	
	public String addCxMessage(Customer cx)
	{
		kafkaTemplate.send(AppConstants.TOPIC_NAME, cx);
		return "Customer Data Added into Kafka Server";
	}
}
