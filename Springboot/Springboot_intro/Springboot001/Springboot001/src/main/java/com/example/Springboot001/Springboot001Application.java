package com.example.Springboot001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.Springboot001.service.Greetings;

/* output
 * Configuration bean created
Greetings bean created
2024-10-25T00:47:59.755-04:00  INFO 2464 --- [Springboot001] [           main] c.e.S.Springboot001Application           : Started Springboot001Application in 1.198 seconds (process running for 1.713)
Good morning NameABC
 */


@SpringBootApplication
public class Springboot001Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext IOCcontainer = SpringApplication.run(Springboot001Application.class, args);
		Greetings greet = IOCcontainer.getBean(Greetings.class);
		
		String message = greet.generateWish("NameABC");
		System.out.println(message);
		
	}

}
