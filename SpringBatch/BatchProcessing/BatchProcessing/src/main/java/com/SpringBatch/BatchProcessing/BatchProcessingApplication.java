package com.SpringBatch.BatchProcessing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Batch processing : Processing bulk data at a time.
/*
* Processing thousands of pay slips of employees. at a time, they are processing thousands of records.
*/

/*
* JobLauncher -> Job -> Step -> one ItemReader, one ItemWriter, one ItemProcessor
  |		|	|
	  JobRepository

*/

//ItemReader will read external dataset into application
//ItemProcessor will process the data
//ItemWriter will write data into database
//All the above 3 go into Step
//Multiple steps go into a Job
//Job Launcher runs the job


/* [BatchProcessing] [  restartedMain] o.s.batch.core.step.AbstractStep         : Step: [step-1] executed in 6s104ms
[BatchProcessing] [  restartedMain] o.s.b.c.l.s.TaskExecutorJobLauncher      : Job: [SimpleJob: [name=customer-import-job]] completed with the following parameters: [{}] and the following status: [COMPLETED] in 6s191ms
*/

/* Java is one of the fastest programming languages, it read the file, processed and wrote the data into database in 6s191ms */


@SpringBootApplication
public class BatchProcessingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatchProcessingApplication.class, args);
	}

}
