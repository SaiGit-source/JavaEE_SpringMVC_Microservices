package com.MongoDB.Joblisting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MongoDB.Joblisting.model.JobPost;
import com.MongoDB.Joblisting.repo.IPostRepo;
import com.MongoDB.Joblisting.repo.ISearchRepo;

@Service
public class PostingService implements IPostingService {
	
	@Autowired
	private IPostRepo repo;
	
	@Autowired
	private ISearchRepo searchRepo;
	
	@Override
	public List<JobPost> fetchAllRecords() {
	
		return repo.findAll();
	}

	@Override
	public JobPost addNewPosting(JobPost jobpost) {
		return repo.save(jobpost);
	}

	@Override
	public List<JobPost> fetchByKeyword(String keyword) {
		return searchRepo.findByText(keyword);
	}

}
