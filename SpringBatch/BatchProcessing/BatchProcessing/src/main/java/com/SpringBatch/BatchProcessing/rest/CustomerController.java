package com.SpringBatch.BatchProcessing.rest;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Batch processing : Processing bulk data at a time.
/*
 * Processing thousands of pay slips of employees. at a time, they are processing thousands of records.
 */

/*
 * JobLauncher -> Job -> Step -> one ItemReader, one ItemWriter, one ItemProcessor
     |		|	|
	  JobRepository

 */

// ItemReader will read external dataset into application
// ItemProcessor will process the data
// ItemWriter will write data into database
// All the above 3 go into Step
// Multiple steps go into a Job
// Job Launcher runs the job

/* Java is one of the fastest programming languages, it read the file, processed and wrote the data into database in 6s191ms */

@RestController
public class CustomerController {
	
	@Autowired
	private Job job;
	
	@Autowired
	private JobLauncher jobLauncher;

	@GetMapping("/import")
	public void loadData() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		JobParameters jobParameters = new JobParametersBuilder()
											.addLong("Starts AT", System.currentTimeMillis()).toJobParameters();
		jobLauncher.run(job, jobParameters);
		System.out.println("Data Loaded");
	}
}
