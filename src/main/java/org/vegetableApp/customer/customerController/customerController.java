package org.vegetableApp.customer.customerController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.vegetableApp.address.model.Address;
import org.vegetableApp.customer.model.Customer;
import org.vegetableApp.customer.service.CustomerService;


@Controller
@RequestMapping("/customer")
public class customerController {
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/addcustomer")
	public String addCustomer(Model model) {
		Customer customer = new Customer();
		customer.setAddress(new Address());
		model.addAttribute("customer",customer);
		return "customer/addcustomer";
	}
	
	@PostMapping("/addcustomerprocess")
	public String addCustomerProcess(@ModelAttribute("customer") Customer customer) {
		Customer cust = customerService.addCustomer(customer);
		if(cust == null ) {
			return "customer/customeraddunsuccess";
		}else {
			return "customer/customeraddsuccess";
		}
	}
	
	@GetMapping("/updatecustomer")
	public String updateVegetable(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer",customer);
		return "customer/updatecustomer";
	}
	
	@GetMapping("/customersearchforupdate")
	public String searchForUpdate(@ModelAttribute("customer") Customer customer,Model model) {
		Customer cust = customerService.viewCustomer(customer.getCustomerId());
		if(cust == null) {
			return "customer/customernotfound";
		}else {
			model.addAttribute("customer",cust);
			return "customer/customerupdatesearch";
		}
	}
	
	
	@PostMapping("/updatecustomerprocess")
	public String updateVegetableProcess(@ModelAttribute("customer") Customer customer){
		customer = customerService.updateCustomer(customer);
		if(customer == null) {
			return "customer/customerupdateunsuccess";
		}else {
			return "customer/customerupdatesuccess";
		}
	}
	
	


}
