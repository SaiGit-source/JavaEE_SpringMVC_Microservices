package com.springboot.SpringDataJPA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * create SQL query automatically
 * 
 * Hibernate: 
    create table person (
        id integer not null,
        city varchar(255),
        name varchar(255),
        primary key (id)
    )
 */

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
		// nothing else to write here
		// just create a run file
	}

}
