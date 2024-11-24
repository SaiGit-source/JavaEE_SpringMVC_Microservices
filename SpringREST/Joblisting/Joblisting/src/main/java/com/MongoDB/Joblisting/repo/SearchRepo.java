package com.MongoDB.Joblisting.repo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Repository;

import com.MongoDB.Joblisting.model.JobPost;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Repository
public class SearchRepo implements ISearchRepo {
	
	@Autowired
	private MongoClient mongoClient;
	
	@Autowired
	private MongoConverter converter;

	
	// we are getting the search query from MongoDB itself. Click on Export to Language then select Java. this will export the entire Aggregate search->sort->limit pipeline into Java code
	// https://cloud.mongodb.com/v2/674253ae10fd78232993d7d7#/metrics/replicaSet/6742550980b2be27118cd825/explorer/miniproject/JobPost/aggregation
	
	@Override
	public List<JobPost> findByText(String keyword) {
		
		MongoDatabase database = mongoClient.getDatabase("miniproject");
		MongoCollection<Document> collection = database.getCollection("JobPost");
		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search", 
		    new Document("index", "default")
		            .append("text", 
		    new Document("query", keyword)
		                .append("path", Arrays.asList("desc", "techs", "profile")))), 
		    new Document("$sort", 
		    new Document("exp", 1L)), 
		    new Document("$limit", 5L)));
		
		final List<JobPost> posts=new ArrayList<>();
		
		result.forEach(doc -> posts.add(converter.read(JobPost.class, doc))); // we need to convert Document class into JobPost class
		
		return posts;
	}

}
