package com.Microservices.APIGateway.routes.cktbreaker;

import java.net.URI;

import org.springframework.cloud.gateway.server.mvc.filter.CircuitBreakerFilterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

/*
 * Circuit Breaker Pattern:
How to make our microservices resilient?
All requests -> API gateway -> microservice1
			    -> microservice2
Lets say we are getting 30 requests to a microservice, all 30 are first going to API gateway. that might be a burden to API gateway. API gateway might go down
in case of such API gateway failure, how to make application resilient. burden should not go to API gateway
thats why we got to implement 'Circuit breaker pattern'
 */

// we need to add the dependency: Spring Cloud Circuit Breaker -> Resillience4J library

// Testing circuit breakers
// FeignClientMicro is UP
// first i send request to http://localhost:8448/getWelcomePage
// i get response: FeignClient: Welcome to the main page! I am the Main microservice from port: 8582 coming from MainMicroservice

// check CircuitBreaker status
// GET to http://localhost:8448/actuator/circuitbreakers
/*
 * {
    "circuitBreakers": {
        "FeignCircuitBreaker": {
            "state": "OPEN"
        }
    }
}
 */

// FeignClientMicro is DOWN
// GET to http://localhost:8448/getWelcomePage
// Output: Service Currently Unavailable, try again after some time!
// i repeat for 5 times

// GET http://localhost:8448/actuator/circuitbreakers
/*
 * {
    "circuitBreakers": {
        "FeignCircuitBreaker": {
            "state": "HALF_OPEN"
        }
    }
}
 */

// i retry more times

/*
 * {
    "circuitBreakers": {
        "FeignCircuitBreaker": {
            "state": "OPEN"
        }
    }
}
 */

// as long as FeignClientMicro is down, we get Circuit Breaker States between "OPEN" and "HALF_OPEN"

@Configuration
@Primary
public class CircuitBreaker {
	
	@Bean
	public RouterFunction<ServerResponse> feignCircuitService()
	{
		return GatewayRouterFunctions.route("FeignClientMicro")
				.route(RequestPredicates.path("/getWelcomePage"),
				HandlerFunctions.http("http://localhost:8085"))
				.filter(CircuitBreakerFilterFunctions.circuitBreaker("FeignCircuitBreaker", 
						URI.create("forward:/fallbackRoute"))).build();
	}
	
	@Bean
	public RouterFunction<ServerResponse> fallbackRoute()
	{
		return GatewayRouterFunctions.route("fallbackRoute")
				.GET("/fallbackRoute", request->ServerResponse.status(HttpStatus.SERVICE_UNAVAILABLE)
				.body("Service Currently Unavailable, try again after some time!"))
				.build();
	}
		
	@Bean
	public RouterFunction<ServerResponse> mainTestService()
	{
		return GatewayRouterFunctions.route("MainMicroservice")
				.route(RequestPredicates.path("/get-main-info"),
				HandlerFunctions.http("http://localhost:8582")).build();
	}


}
