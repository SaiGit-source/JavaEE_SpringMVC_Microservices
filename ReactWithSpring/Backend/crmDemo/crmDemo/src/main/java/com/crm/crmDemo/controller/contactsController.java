package com.crm.crmDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.crmDemo.model.Contact;
import com.crm.crmDemo.service.contactService;



@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class contactsController {

    @Autowired
    private contactService contactService;

    @GetMapping("/contacts")    
    public List<Contact> getContacts(){
            return contactService.getContacts();
    }

    @PostMapping("/contacts")
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
        Contact newContact = contactService.createContact(contact);
        return ResponseEntity.ok(newContact);
    }
    

}
