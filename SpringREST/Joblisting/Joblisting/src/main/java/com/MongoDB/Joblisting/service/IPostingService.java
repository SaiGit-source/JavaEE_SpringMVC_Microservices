package com.MongoDB.Joblisting.service;

import java.util.List;

import com.MongoDB.Joblisting.model.JobPost;

public interface IPostingService {
	
	public List<JobPost> fetchAllRecords();
	public JobPost addNewPosting(JobPost jobpost);
	public List<JobPost> fetchByKeyword(String keyword);
	

}
