package com.springboot.beanlifecycle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// in this example, we illustrate the Bean lifecycle
// Static block -> Java instance block -> Constructor -> Method calls -> Bean destruction
/*
 * Bean static block
Java initialization block
Constructor: Bean created
Init method of Alien
Disp method - business logic
Destroy bean
 */

// we only called the disp() method but all above have been executed before method call

import org.springframework.context.ConfigurableApplicationContext;

import com.springboot.beanlifecycle.service.Alien;

@SpringBootApplication
public class BeanlifecycleApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext IOCcontainer = SpringApplication.run(BeanlifecycleApplication.class, args);
		Alien alien = IOCcontainer.getBean(Alien.class);//now the bean is created and is in the IOCcontainer
		alien.disp();
		IOCcontainer.close();
	}

}
