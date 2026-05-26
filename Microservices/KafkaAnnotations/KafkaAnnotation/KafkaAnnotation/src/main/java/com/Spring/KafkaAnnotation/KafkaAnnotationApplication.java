package com.Spring.KafkaAnnotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;


@EnableKafka
@SpringBootApplication
public class KafkaAnnotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaAnnotationApplication.class, args);
	}

}
