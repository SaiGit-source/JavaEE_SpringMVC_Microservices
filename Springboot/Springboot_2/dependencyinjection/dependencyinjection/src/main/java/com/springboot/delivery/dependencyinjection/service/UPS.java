package com.springboot.delivery.dependencyinjection.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class UPS implements DeliveryInterface{

	public UPS() {
		super();
		System.out.println("UPS Constructor: UPS bean created");
	}

	@Override
	public Boolean deliverProductCourrier(Double amount) {
		System.out.println("Product delivered by UPS: "+amount);
		return true;
	}

}
