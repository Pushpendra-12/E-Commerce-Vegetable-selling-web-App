package org.vegetableApp.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vegetableApp.cart.model.Cart;

public interface CartRepository extends JpaRepository<Cart,Integer> {

}
