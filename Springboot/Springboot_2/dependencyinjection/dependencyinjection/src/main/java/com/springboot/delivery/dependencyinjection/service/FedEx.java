package com.springboot.delivery.dependencyinjection.service;

import org.springframework.stereotype.Service;

@Service
public class FedEx implements DeliveryInterface{
	
	public FedEx() {
		super();
		System.out.println("FedEx constructor: FedEx bean created");
	}

	@Override
	public Boolean deliverProductCourrier(Double amount) {
		System.out.println("Product delivered by FedEx: "+amount);
		return true;
	}

}
