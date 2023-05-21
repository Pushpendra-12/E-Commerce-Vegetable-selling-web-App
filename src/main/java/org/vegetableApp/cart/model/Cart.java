package org.vegetableApp.cart.model;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.vegetableApp.vegetable.model.VegetableDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;


@Entity
@Scope("prototype")
@Component
public class Cart {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cartId;
	
	

	@ManyToMany
	@OnDelete(action=OnDeleteAction.CASCADE)
	private List<VegetableDTO> vegList = new ArrayList<>();
	
	

	public Cart() {
		super();
	}
	public Cart(Integer cartId, List<VegetableDTO> vegList) {
		super();
		this.cartId = cartId;
		this.vegList = vegList;
	}


	public Integer getCartId() {
		return cartId;
	}


	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}


	public List<VegetableDTO> getVegList() {
		return vegList;
	}


	public void setVegList(List<VegetableDTO> vegList) {
		this.vegList = vegList;
	}
}
