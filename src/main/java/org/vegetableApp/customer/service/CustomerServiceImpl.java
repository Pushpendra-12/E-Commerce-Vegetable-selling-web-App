package org.vegetableApp.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vegetableApp.address.repository.AddressRepository;
import org.vegetableApp.customer.model.Customer;
import org.vegetableApp.customer.repository.CustomerRepository;




@Service("customerService")
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	
	public Customer addCustomer(Customer customer) {
		addressRepository.save(customer.getAddress());
		return customerRepository.save(customer);
	}
	
	
	public Customer updateCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	
	public Customer removeCustomer(Integer customerId) {
		Optional<Customer> opt = customerRepository.findById(customerId);
		if(opt.isPresent()) {
			Customer cust = opt.get();
			customerRepository.delete(cust);
			return cust;
		}
		return null;
	}
	
	public Customer viewCustomer(Integer customerId)
	{
		Optional<Customer> opt = customerRepository.findById(customerId);
		if(opt.isPresent()) {
			return opt.get();
		}
		return null;
	}
	
	
	public List<Customer> viewAllCustomer(){
		return customerRepository.findAll();
	}

}
