package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.service.Password;

// Stereotype annotations -> are class-level
// Annotation is also a way to talk to Spring framework
// Web layer (Web logic, if RestAPI then @RestController, else @Controller), Service layer (Actual logic of business application will be written), Repo layer (Say we have a database where table is there. All logic to connect to database and perform operations)
// @Component creates a bean 

/* this is the output
 * 	DAO bean created
	Config  bean created
	ServiceLayer bean created
	Utility bean created
	Web bean created
	Password bean created
	The Algo used for password is SHA
 */

public class AnnotationApproachMain {

	public static void main(String[] args) {
		ApplicationContext IOCcontainer=new ClassPathXmlApplicationContext("applicationconfig.xml");
		
		Password p = IOCcontainer.getBean(Password.class);
		p.passWordAlgoUsed();

	}

}
