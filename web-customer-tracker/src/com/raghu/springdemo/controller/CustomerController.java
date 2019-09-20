package com.raghu.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.raghu.springdemo.entity.Customer;
import com.raghu.springdemo.service.CustomerSerivce;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//need to inject Customer service
	@Autowired
	private CustomerSerivce customerSerivce;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		
		//get the customers from the dao
		
	     List<Customer> theCustomers = customerSerivce.getCustomers();
	
		//add the customers to the model
	     System.out.println("The List of Customers:"+theCustomers);
	    model.addAttribute("customers",theCustomers);
		
		return "list-customers";
	}
	
	@GetMapping("showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer",theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		customerSerivce.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String updateCustomer(@RequestParam("customerId") int theId,
			                      Model theModel) {
		
		//get the customer from the service
		Customer theCustomer = customerSerivce.getCustomer(theId);
		
		//set the customer as model attribute to pre-populate the form
		theModel.addAttribute("customer",theCustomer);
		
		//send it to our form
		
		
		return "customer-form";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		customerSerivce.deleteCustomer(theId);
		return "redirect:/customer/list";
	}

}
