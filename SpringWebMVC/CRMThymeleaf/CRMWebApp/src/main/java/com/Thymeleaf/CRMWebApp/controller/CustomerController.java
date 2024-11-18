package com.Thymeleaf.CRMWebApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Thymeleaf.CRMWebApp.model.Customer;
import com.Thymeleaf.CRMWebApp.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	public CustomerService service;
	
	// to display customer list 
	@GetMapping("/cxlistHome")
	public String getAllCxData(Model model) {
		List<Customer> customers = service.getCustomerInfo();
		customers.forEach(c->System.out.println(c));
		model.addAttribute("cxlistKey", customers);
		return "cxlistHomePage";
	}
	
	// for retrieving registration form
	@GetMapping("/registration")
	public String showRegistrationForm(Model model, Customer customer) {
		model.addAttribute("custKey", customer);
		return "registrationForm";
	}
	
	// for registering new customer
	@PostMapping("/registerCustomer") // when you hit register, Customer object is coming from registrationForm post
	public String registerCx(@ModelAttribute("custKey")Customer customer) {
		service.registerCustomer(customer);
		return "redirect:/cxlistHome";
	}
	
	@GetMapping("/updateRecord")
	public String updateCx(@RequestParam("cxidKey")Integer cxID, Model model) {
		//cxidKey is coming from cxlistHomePage
		Customer cxRecord = service.fetchCxbyId(cxID);
		// fetch customer record and populate update form
		// send cxRecord to updateForm
		model.addAttribute("custRecordKey", cxRecord);
		// now the record is available for two-way binding at updateForm
		return "updateForm";
	}
	
	
	@GetMapping("/deleteRecord")
	public String deleteCx(@RequestParam("cxidKey")Integer cxID) {
		service.deleteCustomer(cxID);
		return "redirect:/cxlistHome";
	}

}
