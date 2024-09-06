package main;

import services.FedEx; // importing because of different package
import services.UPS;

public class AmazonMain {

	public static void main(String[] args) {
		AmazonCommon amz = new AmazonCommon(new FedEx()); // we create an object of the common class
		// here AmazonCommon is the Target class and FedEx is the dependent class
		// we are injecting the dependent object into target class so this is 'Constructor injection'
		// Also this is Dependency-Injection
		
		amz.setiDeliver(new UPS()); // here we are injecting dependency at the setter so it is called as Setter injection
		// this is also Dependency-Injection
		// setter injection takes precedence over constructor injection
		// Setter injection is better because Constructor injection requires the dependent object to be ready before the Target object creation as opposed to Setter injection
		// with Setter injection, we can still create the Target object without Dependent object
		
		// Why Dependency-Injection?
		// we want to achieve loose-coupling by not making a class dependent on another class. that's why the AmazonCommon class doesn't have any other classes like FedEx() etc hard-coded in that
		
		Boolean status = amz.AmazonDelivery(3948.345);
		// in the end we should see UPS deliver the product because of setter injection
		// Spring framework takes care of object-creation and dependency-injection that's why it is better
		// objects created by Spring are called as 'bean'
		if (status) {
			System.out.println("Product delivered successfully");
		}
		else {
			System.out.println("Product delivery failed");
		}
	}

}
