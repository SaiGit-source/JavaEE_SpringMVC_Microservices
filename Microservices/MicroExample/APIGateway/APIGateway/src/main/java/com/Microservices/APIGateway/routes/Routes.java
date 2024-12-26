package com.Microservices.APIGateway.routes;

import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class Routes {
	
	// this works as well -> API gateway: http://localhost:8448/getWelcomePage
	// instead of FeignClientMicro -> http://localhost:8086/getWelcomePage
	// that means we dont need to know the Port# of each microservice
	// we are reaching out to API gateway instead
	// FeignClient: Welcome to the main page! I am the Main microservice from port: 8582 coming from MainMicroservice
	
	@Bean
	public RouterFunction<ServerResponse> feignService()
	{
		return GatewayRouterFunctions.route("FeignClientMicro")
				.route(RequestPredicates.path("/getWelcomePage"),
				HandlerFunctions.http("http://localhost:8085")).build();
	}
	
	// note this works as well
	// http://localhost:8448/get-main-info
	// instead of http://localhost:8582/get-main-info
	// Welcome to the main page! I am the Main microservice from port: 8582
	
	@Bean
	public RouterFunction<ServerResponse> mainService()
	{
		return GatewayRouterFunctions.route("MainMicroservice")
				.route(RequestPredicates.path("/get-main-info"),
				HandlerFunctions.http("http://localhost:8582")).build();
	}
	
}
