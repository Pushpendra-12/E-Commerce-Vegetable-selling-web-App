package org.vegetableApp.customer.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.vegetableApp.customer.model.Customer;



public interface CustomerRepository extends JpaRepository<Customer,Integer> {
	

}
