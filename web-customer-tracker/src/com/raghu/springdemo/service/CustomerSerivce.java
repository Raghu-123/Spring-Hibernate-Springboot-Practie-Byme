package com.raghu.springdemo.service;

import java.util.List;

import com.raghu.springdemo.entity.Customer;

public interface CustomerSerivce {

	public List<Customer> getCustomers();
	
	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
}
