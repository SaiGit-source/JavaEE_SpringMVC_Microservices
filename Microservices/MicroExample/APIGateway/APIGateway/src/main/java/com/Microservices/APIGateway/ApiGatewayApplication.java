package com.Microservices.APIGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

// currently i have to say "http://localhost:8086/getWelcomePage" to access the FeignClientMicroservice
// but what if the client is a mobile device or something else. then we cannot be tied to port# of a microservice.
// APIGateway is the entry-point to application and it stands in between Client and Microservice, very similar to FeignClient itself
// APIGateway removes the need to enter the port#

/*
 * this is the entry-point to application same like Feignclient (microservice-microservice interaction) except it is for client-microservice interaction.

client could be from any application -> web, iOS, Android. to access microservice, they have to mention port# of the microservice also. one microservice accessing while one microservice accessing another microservice, they dont need the port#. that's where API Gateway comes into picture, it is the entry-point.

Clients like Web or Mobile doesn't reach out to microservice directly instead they go through API Gateway. All APIs or microservices will be registered with Eureka server. i want to give common entrypoints to all clients and they will be in API gateway. now no matter what the client is, they dont have to mention port# anymore. this port# problem is solved by API Gateway

We can write the logic of routing and API gateway will redirect client requests to microservices

 */

// now instead of FeignClientMicro: "http://localhost:8086/getWelcomePage", we reach out to API Gateway IP: http://localhost:8448/getWelcomePage
// output: FeignClient: Welcome to the main page! I am the Main microservice from port: 8582 coming from MainMicroservice


@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}
