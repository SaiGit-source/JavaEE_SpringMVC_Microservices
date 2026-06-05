package com.crm.crmDemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crm.crmDemo.model.Contact;

//@CrossOrigin(origins = "http://localhost:3000") // adding Controller for Cors issue
@Repository
public interface contactRepo extends JpaRepository<Contact, Long> { 
    
}