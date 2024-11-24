package com.MongoDB.Joblisting.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.MongoDB.Joblisting.model.JobPost;

public interface IPostRepo extends MongoRepository<JobPost, String> {

}
