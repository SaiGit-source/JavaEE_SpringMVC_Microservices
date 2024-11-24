package com.MongoDB.Joblisting.repo;

import java.util.List;

import com.MongoDB.Joblisting.model.JobPost;

public interface ISearchRepo {

	public List<JobPost> findByText(String keyword);
}
