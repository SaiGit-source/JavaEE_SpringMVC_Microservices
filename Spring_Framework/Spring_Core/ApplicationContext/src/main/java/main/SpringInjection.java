package main;
// The idea of SpringInjection is we are giving inversion of control (IOC) to Spring framework to create objects(beans) and inject them
// two ways to create IOC containers: Application context and Bean factory
// this is an example of Application context

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * Eager initialization
 * Both Java and Springboot beans are created even though only Java object is being used
 * Java bean created
	Springboot bean created
	Java course purchased for 2343.44
	Course purchased successfully
 * */

public class SpringInjection {

	public static void main(String[] args) {
		// we are creating IOC container with Application Context and App context is internal to SpringBoot
		// When IOC container is created, App context promotes Eager initialization, that's initialization of objects when container is created
		ApplicationContext IOCcontainer=new ClassPathXmlApplicationContext("applicationconfig.xml");
		
		Udemy udemy = IOCcontainer.getBean(Udemy.class); // we are not creating objects here
		
		Boolean status = udemy.buyTheCourse(2343.44);
		
		if (status) {
			System.out.println("Course purchased successfully");
		}
		else {
			System.out.println("Failed to purchase course");
		}
		
	}

}
