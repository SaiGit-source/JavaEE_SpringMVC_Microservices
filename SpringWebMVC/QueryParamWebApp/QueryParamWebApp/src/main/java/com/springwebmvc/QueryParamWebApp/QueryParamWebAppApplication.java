package com.springwebmvc.QueryParamWebApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// if client is sending data, how to receive data at Server? three ways: Query parameter, Path parameter, Form data
// data is coming through URL

// http://localhost:8888/QueryParam/getinfo?name=Abc&course=Java

@SpringBootApplication
public class QueryParamWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(QueryParamWebAppApplication.class, args);
	}

}
