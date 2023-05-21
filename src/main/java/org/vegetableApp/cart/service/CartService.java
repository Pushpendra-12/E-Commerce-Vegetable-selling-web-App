package org.vegetableApp.cart.service;

import org.vegetableApp.cart.model.Cart;
import org.vegetableApp.vegetable.model.VegetableDTO;

public interface CartService {
	public Cart addCart(Cart cart);
	public Cart getCartById(Integer cartId);
	public Cart removeItem(Cart cart,VegetableDTO vegetable);

}
