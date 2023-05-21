package org.vegetableApp.customer.model;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.vegetableApp.address.model.Address;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;




@AllArgsConstructor
@Data
@Entity
@Component
@Scope("prototype")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer customerId;
	private String name;
	private String mobileNo;
	private String emailId;
	private String password;
	
	public Customer() {
	}

	
	
	
	public Customer(String name, String mobileNo, String emailId, String password, Address address) {
		super();
		this.name = name;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.password = password;
		this.address = address;
	}




	@OneToOne(cascade = {CascadeType.ALL})
	private Address address;
   
}
