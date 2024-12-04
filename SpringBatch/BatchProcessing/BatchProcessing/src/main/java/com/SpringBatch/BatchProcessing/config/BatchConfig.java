package com.SpringBatch.BatchProcessing.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.SpringBatch.BatchProcessing.model.Customer;
import com.SpringBatch.BatchProcessing.repo.ICustomerRepo;

@Configuration
public class BatchConfig {

	@Autowired
	private ICustomerRepo repo;
	
	@Autowired
	private JobRepository jobRepo; 
	
	@Autowired
	private PlatformTransactionManager transactionManager;
	
	// ItemReader
	@Bean // to make it part of IOC container
	public FlatFileItemReader<Customer> itemReader(){
		FlatFileItemReader<Customer> reader = new FlatFileItemReader<>();
		reader.setResource(new FileSystemResource("src/main/resources/customer_data.csv")); // specify file source
		reader.setName("csv-reader");
		reader.setLinesToSkip(1); // skip header row in csv file
		reader.setLineMapper(lineMapper());
		return reader;
	}
	
	// ItemReader: LineMapper
	
	public LineMapper<Customer> lineMapper(){
		DefaultLineMapper<Customer> lineMapper = new DefaultLineMapper<>();
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		tokenizer.setDelimiter(","); // csv file is comma-seperated file so we put ','
		tokenizer.setStrict(false); // it will ignore null or empty cells as well
		tokenizer.setNames("customerID","firstName","lastName","email","phoneNumber","address","city","state","zipCode","country"); // Header in csv file
		BeanWrapperFieldSetMapper<Customer> beanWrapper = new BeanWrapperFieldSetMapper<>();
		beanWrapper.setTargetType(Customer.class); // binding to Customer class
		
		lineMapper.setLineTokenizer(tokenizer);
		lineMapper.setFieldSetMapper(beanWrapper);
		return lineMapper;
	}
	
	
	// ItemProcessor
	
	@Bean
	public CustomerProcessor processCxData() {
		
		return new CustomerProcessor();
	}
	
	
	// ItemWriter
	
	@Bean
	public RepositoryItemWriter<Customer> itemWriter(){
		RepositoryItemWriter<Customer> writer = new RepositoryItemWriter<>();
		writer.setRepository(repo);
		writer.setMethodName("save"); // save() is the method in JPARepository to save into database
		return writer;
	}
	
	
	// Step
	
	@Bean
	public Step step1() {
		return new StepBuilder("step-1", jobRepo)
				.<Customer, Customer>chunk(10, transactionManager) // read 10 records at a time
				.reader(itemReader()) // itemReader first
				.processor(processCxData()) // itemProcessor methodName
				.writer(itemWriter()) // itemWriter methodName
				.build();
	}
	
	
	// Job
	@Bean
	public Job job() {
		return (Job) new JobBuilder("customer-import-job", jobRepo)
									.start(step1()) // we could have multiple steps in a job
									.build();
	}
}
