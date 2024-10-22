package main;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

//Bean factory promotes Lazy initialization: it will create objects only if you use them
//two ways to create IOC containers: Application context and Bean factory

// this is an example of Bean Factory


/*
 * Java object is not created here
 * 
 * 	Udemy bean created
	Springboot bean created
	Springboot course purchased for 450.3
	Course purchased successfully
 */

public class BeanFactoryMain {

	public static void main(String[] args) {
		DefaultListableBeanFactory beanFactory =new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
		
		reader.loadBeanDefinitions("applicationconfig.xml");
		
		Udemy udemy = beanFactory.getBean(Udemy.class);
		// we are doing setter injection here
		
		Boolean status = udemy.buyTheCourse(450.30);
		
		if (status) {
			System.out.println("Course purchased successfully");
		}
		else {
			System.out.println("Failed to purchase course");
		}

	}

}
