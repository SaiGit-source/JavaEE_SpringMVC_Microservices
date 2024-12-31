package com.Kafka.Subscriber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import com.Kafka.Subscriber.util.AppConstants;

// to run -> Start Zookeeper, Kafka
// zookeeper-server-start.bat zookeeper.properties
// kafka-server-start.bat kafka.properties
// start PublisherApplication -> run as Java application
// Postman: POST: http://localhost:8080/addCx
/* Body
 * {
"id": 1,
"name": "Abc",
"city": "Brooklyn"
}
 */


// once message is sent from publisher / Postman POST, it shows up in the console

/*
 * 	// check the terminal console
	/*
	 * 2024-12-30T22:41:35.281-05:00  INFO 20252 --- [Subscriber] [ntainer#0-0-C-1] o.s.k.l.KafkaMessageListenerContainer    : group_kafka_customer: partitions assigned: [kafka-topic-0]
	 * Msg Recieved From Kafka server* :: {"id":1,"name":"Abc","city":"Brooklyn"}
	*/

// From Kafka Server* since Kafka is the message broker here



@SpringBootApplication
public class SubscriberApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubscriberApplication.class, args);
	}
	
	@KafkaListener(topics = AppConstants.TOPIC_NAME, groupId="group_kafka_customer")
	public void subscribeMsg(String cxData) {
			System.out.print("* Msg Recieved From Kafka server* :: ");
			System.out.println(cxData);
		
	}


}
