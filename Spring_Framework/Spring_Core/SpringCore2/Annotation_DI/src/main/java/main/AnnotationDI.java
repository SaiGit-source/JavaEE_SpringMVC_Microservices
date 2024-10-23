package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.Udemy;

// we are telling Spring framework to refer to Annotations not XML
// <context:annotation-config/>

// @Autowired -> automatic dependency injection 'byType' - setter injection
// throws an exception if we dont have @Primary or @Qualifier
// by: org.springframework.beans.factory.NoUniqueBeanDefinitionException: No qualifying bean of type 'service.ICourse' available: expected single matching bean but found 2: java,springBoot

// Annotated Java as @Primary constructor injection
// Annotated with @Qualifier("springBoot") at setter injection
// @Qualifier takes precedence over @Primary

/* Setter injection and SpringBoot is purchased -> Qualifier takes precedence over @Primary
 * 	Java Bean Created
	SpringBoot Bean created
	Udemy Bean created
	Setter Injection
	SpringBoot Course is purchased and amount paid is 2500.0
	Course Purchased Successfully
 */

public class AnnotationDI {

	public static void main(String[] args) {
		
		ApplicationContext IOCcontainer=new ClassPathXmlApplicationContext("applicationconfig.xml");

		Udemy udemy = IOCcontainer.getBean(Udemy.class);
		
		Boolean status=udemy.buyTheCourse(2500.0);
		if(status)
			System.out.println("Course Purchased Successfully");
		else
			System.out.println("Failed to buy the course");
	}


}

