package com.Kafka.Publisher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * Microservice1 (Producer of data) -> Zookeeper (Kafka runs on Zookeeper) -> Kafka server (Kafka topic -> message) -> Microservice2 (Consumer of data). Apache Kafka is a message broker

Microservice1 will publish data into Kafka topic -> specify the location of Kafka topic and Kafka server then Microservice2 can read from there

Dependency: Spring for Apache Kafka

App1(Publisher->configure ProducerFactory > KafkaTemplate) -> Zookeeper[Kafka server[Topic[message in the form of key-value pair]]] -> App2(Subscriber->configure ConsumerFactory -> KafkaListener)

Default port number of Kafka is 9092

Publisher application could be Python application and Subscriber application could be Spring application


 */



@SpringBootApplication
public class PublisherApplication {

	public static void main(String[] args) {
		SpringApplication.run(PublisherApplication.class, args);
	}

}
