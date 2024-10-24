package com.onlyannotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.onlyannotation.config.JavaConfiguration;
import com.onlyannotation.service.Greetings;

// this is AnnotationOnly approach and we dont even have an XML file

/* Output
 * Java Config Bean created
Greetings bean created
Java configuration, createTimeObject method
Good Afternoon to you Name123
 */

public class OnlyAnnotations {

	public static void main(String[] args)
	{
		//BeanFactory
		//ApplicationContext
		
		
		ApplicationContext container=new AnnotationConfigApplicationContext(JavaConfiguration.class);

		
		Greetings greet = container.getBean(Greetings.class);
		
		System.out.println(greet.generateGreeting("Name123"));
		
	}

}