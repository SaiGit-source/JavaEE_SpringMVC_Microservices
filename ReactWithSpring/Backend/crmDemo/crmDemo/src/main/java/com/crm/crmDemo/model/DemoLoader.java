package com.crm.crmDemo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.crm.crmDemo.repo.contactRepo;

@Component
public class DemoLoader implements CommandLineRunner {

    @Autowired
    private contactRepo contactRepo;

    @Override
    public void run(String... args) throws Exception {
        // Code to load initial data into the database
        // For example, you can create some demo contacts and save them to the database
        contactRepo.save(new Contact("Dave", "Doe", "dave.doe@example.com"));
    }

}
