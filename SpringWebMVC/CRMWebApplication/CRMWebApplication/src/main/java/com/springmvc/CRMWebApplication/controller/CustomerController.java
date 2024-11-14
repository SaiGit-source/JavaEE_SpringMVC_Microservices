package com.springmvc.CRMWebApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.CRMWebApplication.model.Customer;
import com.springmvc.CRMWebApplication.service.CustomerService;

// http://localhost:8686/CRMApp/cxlistHome

@Controller
public class CustomerController {
	
	// it creates only one CustomerService bean @Service and injects here
	@Autowired
	private CustomerService service;
	
	@GetMapping("/registration")
	public String showRegisterForm(Model model, Customer customer) {
		model.addAttribute("custKey", customer);
		return "registrationForm";
	}
	
	@GetMapping("/cxlistHome")
	public String getAllCxData(Model model) {
		List<Customer> cxlist = service.getCustomerInfo();
		cxlist.forEach(c->System.out.println(c));
		model.addAttribute("cxlistKey", cxlist);
		return "cxlistPage";
	}
	
	@PostMapping("/registerCustomer")
	public String registerCx(@ModelAttribute("custKey")Customer customer) {
		service.registerCustomer(customer);
		return "redirect:/cxlistHome";
	}
	// cxlistPage.jsp extracts customer-cid from 'for loop' and makes it available on 'updateRecord' url then @RequestParam gets cxid key from there 
	// basically when you click the updateLink the page 'updateRecord' should have the cust cid available at the key 'cxid'	
	// http://localhost:8686/CRMApp/updateRecord?cxid=435
	@GetMapping("/updateRecord") // we retrieve data into form using @RequestParam
	public String updateCx(@RequestParam("cxid")Integer cid, Model model) {
		Customer custRecord = service.fetchCxbyId(cid);
		model.addAttribute("custRecordKey", custRecord);
		return "updateForm";
	}
	// Customer with ID: 102 is deleted
	@GetMapping("/deleteRecord") //@RequestParam acquires cxid from url 
	public String deleteCx(@RequestParam("cxid")Integer cid, Model model) {
		service.deleteCustomer(cid);
		System.out.println("Customer with ID: "+cid+ " is deleted");
		return "redirect:/cxlistHome";
	}

	
}
