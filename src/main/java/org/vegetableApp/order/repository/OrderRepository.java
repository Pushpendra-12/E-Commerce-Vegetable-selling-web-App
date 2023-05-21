package org.vegetableApp.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vegetableApp.order.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
