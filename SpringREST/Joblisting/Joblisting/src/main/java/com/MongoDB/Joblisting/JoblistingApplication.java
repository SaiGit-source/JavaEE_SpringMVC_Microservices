package com.MongoDB.Joblisting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// say if you want to search for a single word, we want to create Indexes
// browse collection -> Search Indexes
// https://cloud.mongodb.com/v2/674253ae10fd78232993d7d7#/clusters/atlasSearch/ClusterTest?database=miniproject&collectionName=JobPost
// create index then look for "Search Tester"

// Aggregation: add stage Aggregation pipline
// https://cloud.mongodb.com/v2/674253ae10fd78232993d7d7#/metrics/replicaSet/6742550980b2be27118cd825/explorer/miniproject/JobPost/aggregation
// select "$search" in the listbox
/* search
 * {
  index: 'default',
  text: {
    query: 'java',
    path: ['desc', 'techs', 'profile']
  }
}
 */

// next is sorting Add Stage $sort

/*
 * {
  $exp: 1
}
 */

// Add Stage $limit
// 5 limit to 5 documents

// to encrypt some of the private info like SSN etc
// Field encryption in MongoDB
// the moment we send data from Server to Database data gets encrypted
// Atlas will decrypt data automatically from Database to Server


@SpringBootApplication
@EnableSwagger2
public class JoblistingApplication {
// this code is only for Swagger nothing else	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)).paths(PathSelectors.any())
				.build().apiInfo(apiInfo()).useDefaultResponseMessages(false);
	}

	@Bean
	public ApiInfo apiInfo() {
		final ApiInfoBuilder builder = new ApiInfoBuilder();
		return builder.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(JoblistingApplication.class, args);
	}

}
