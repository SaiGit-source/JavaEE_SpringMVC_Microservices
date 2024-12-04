package com.SpringBatch.BatchProcessing.config;

import org.springframework.batch.item.ItemProcessor;

import com.SpringBatch.BatchProcessing.model.Customer;

public class CustomerProcessor implements ItemProcessor<Customer, Customer>{

	@Override
	public Customer process(Customer item) throws Exception {
		// Logic to process, clean and filter data
		// if i want only city="Xyz" etc
		return item;
	}

}
