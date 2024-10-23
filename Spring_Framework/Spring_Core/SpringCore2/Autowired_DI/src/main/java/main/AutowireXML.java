package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * i want dependency injection to happen automatically without <propery> or <constructor> in xml file. 
 * <bean id="udemy" class="Udemy.class" autowire="byType"/> autowire creates dep injection automatically
 * autowire="byType" -> setter injection
 * autowire="constructor" // constructor injection
 * autowire-candidate="false" -> dont consider this candidate for dep inj
 * autowire="byName -> matches by variable name
 * autowire="no" No autowiring
 */

/*autowire="byType" only setter injection
 * Java Bean Created
SpringBoot Bean created
Udemy Bean created
Setter Injection
SpringBoot Course is purchased and amount paid is 2500.0
Course Purchased Successfully

 */

/* when we dont set primary=true
 * No qualifying bean of type 'service.ICourse' available: expected single matching bean but found 2: java,sb
 */

/* autowire="constructor"
 * Java Bean Created
Constructor Injection
Java Course is purchased and amount paid is 2500.0
Course Purchased Successfully
 */

public class AutowireXML {

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

