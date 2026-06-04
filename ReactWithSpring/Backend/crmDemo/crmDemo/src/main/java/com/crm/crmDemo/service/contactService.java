package com.crm.crmDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.crmDemo.model.Contact;
import com.crm.crmDemo.repo.contactRepo;

@Service
public class contactService {

    @Autowired
    private contactRepo contactRepo;


    public Contact createContact(Contact contact) {
        return contactRepo.save(contact);
    }

    public List<Contact> getContacts() {
        return contactRepo.findAll();
    }

}
