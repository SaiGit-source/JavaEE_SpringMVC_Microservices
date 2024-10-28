package com.springboot.delivery.dependencyinjection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class Amazon {
	
	// for dependency injection first we need to create an interface/parent ref variable
	private DeliveryInterface deliveryService;
	
	
	// Constructor injection
	public Amazon(DeliveryInterface deliveryService) {
		super();
		System.out.println("Amazon Constructor: Amazon bean created");
		this.deliveryService=deliveryService;
	}


	public DeliveryInterface getDeliveryService() {
		return deliveryService;
	}

	// where we want to inject dependencies
	// this is the place to inject dependencies
	@Autowired
	@Qualifier("fedEx") // camel case of classname will be the bean id by default
	public void setDeliveryService(DeliveryInterface deliveryService) {
		this.deliveryService = deliveryService;
	}
	
	public Boolean deliverProductAmazon(Double amount) {
		return deliveryService.deliverProductCourrier(amount);
	}

}
