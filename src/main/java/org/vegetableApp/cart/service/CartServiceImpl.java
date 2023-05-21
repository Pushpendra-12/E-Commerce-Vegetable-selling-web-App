package org.vegetableApp.cart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vegetableApp.cart.model.Cart;
import org.vegetableApp.cart.repository.CartRepository;
import org.vegetableApp.vegetable.model.VegetableDTO;
import org.vegetableApp.vegetable.repository.VegetableRepository;

@Service("cartService")
public class CartServiceImpl implements CartService {
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private VegetableRepository vegetableRepository;
	
	
	
	public CartServiceImpl(CartRepository cartRepository, VegetableRepository vegetableRepository) {
		super();
		this.cartRepository = cartRepository;
		this.vegetableRepository = vegetableRepository;
	}


	@Override
	public Cart addCart(Cart cart) {
		// TODO Auto-generated method stub
		return cartRepository.save(cart);
	}

	
	@Override
	public Cart getCartById(Integer cartId) {
		Optional<Cart> opt = cartRepository.findById(cartId);
		if(opt.isPresent())
			return opt.get();
		return null;
	}


	@Override
	public Cart removeItem(Cart cart, VegetableDTO vegetable) {
		// TODO Auto-generated method stub
		List<VegetableDTO> vegList=cart.getVegList();
		vegList.remove(vegetable);
		cart.setVegList(vegList);
		return cart;
	}

}
