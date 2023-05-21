package org.vegetableApp.address.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer addressId;
	private String address;
	private String city;
	private String pinCode;
	private String State;
	

	public Address() {
	}


	public Address(Integer addressId, String address, String city, String pinCode, String state) {
		super();
		this.addressId = addressId;
		this.address = address;
		this.city = city;
		this.pinCode = pinCode;
		State = state;
	}

	
}
