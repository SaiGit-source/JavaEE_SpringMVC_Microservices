package com.springboot.delivery.dependencyinjection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.springboot.delivery.dependencyinjection.service.Amazon;

/*
 * we made UPS @Primary but FedEx as @Qualifier, @Qualifier takes precedence
 * 	UPS Constructor: UPS bean created
	Amazon Constructor: Amazon bean created
	FedEx constructor: FedEx bean created
	#Beans: 55
	Product delivered by FedEx: 2334.32
	Product delivered successfully
 */

@SpringBootApplication
public class DependencyinjectionApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext IOCcontainer = SpringApplication.run(DependencyinjectionApplication.class, args);
		Amazon amazon = IOCcontainer.getBean(Amazon.class);
		// we created only 3 beans - Amazon, FedEx and UPS but it shows 55 because 52 other beans required 
		System.out.println("#Beans: "+IOCcontainer.getBeanDefinitionCount());
		Boolean status = amazon.deliverProductAmazon(2334.32);
		if (status) {
			System.out.println("Product delivered successfully");
		}
		else {
			System.out.println("Failed to deliver");
		}
	}

}
