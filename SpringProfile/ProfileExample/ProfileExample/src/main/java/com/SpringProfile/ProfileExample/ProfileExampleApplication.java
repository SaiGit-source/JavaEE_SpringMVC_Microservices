package com.SpringProfile.ProfileExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Profile;

import com.SpringProfile.ProfileExample.service.ICourse;
/*
 * SpringBoot Profiles let you deploy application on multiple environments with minimal changes
 * we create multiple application.properties files with server port# or Database info
 * we can create multiple application.properties files with multiple configurations for prod, sit, dev, pilot environments, which makes deployment of application very easy
 * in application.properties file we set "spring.profiles.active=prod"
 * in prod: server.port=8182
 * Output: o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8182 (http) with context path '/'
 * 
 * @Profile lets you create profile for the bean 
 * we have set "spring.profiles.include=devops" in application.properties
 * Output: "DevOps course purchased for 2323.124"
 * Even though we set @Primary in SpringBoot.java
 * So @Profile takes precedence over @Primary in class files
 */

// No controller, MVC or nothing thats why we are using the main() method in the application file itself

@SpringBootApplication
public class ProfileExampleApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext IOCContainer = SpringApplication.run(ProfileExampleApplication.class, args);
		ICourse courseBean = IOCContainer.getBean(ICourse.class);
		System.out.println(courseBean.purchaseCourse(2323.124));
	}

}
