package org.vegetableApp.user.model;
import org.vegetableApp.address.model.Address;
import org.vegetableApp.cart.model.Cart;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@AllArgsConstructor
@Data
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userId;	
	
	private String name;
	private String mobileNo;
	private String userName;
	private String password;
	

	@OneToOne(cascade = {CascadeType.ALL})
	private Cart cart = new Cart();
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Address address;
	
	public User() {
	}

	public User(String userName, String password,Address address) {
		super();
		this.userName = userName;
		this.password = password;
		this.address = address;
	}
}
