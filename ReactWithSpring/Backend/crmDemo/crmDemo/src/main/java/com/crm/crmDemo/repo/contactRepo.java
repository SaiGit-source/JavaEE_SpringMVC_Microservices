package com.crm.crmDemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crm.crmDemo.model.Contact;

@Repository
public interface contactRepo extends JpaRepository<Contact, Long> {

}
