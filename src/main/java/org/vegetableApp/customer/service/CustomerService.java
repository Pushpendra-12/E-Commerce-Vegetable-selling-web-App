package org.vegetableApp.customer.service;

import java.util.List;

import org.vegetableApp.customer.model.Customer;


public interface CustomerService {
	public Customer addCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public Customer removeCustomer(Integer customerId);
	public Customer viewCustomer(Integer customerId);
	public List<Customer> viewAllCustomer();
}
