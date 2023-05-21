package org.vegetableApp.order.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vegetableApp.order.model.Order;
import org.vegetableApp.order.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Order addOrder(Order order) {
		
		return orderRepository.save(order);
	}

	@Override
	public Order findOrderById(Integer orderId) {
		
		Optional<Order> opt=orderRepository.findById(orderId);
		if(opt.isPresent())
			return opt.get();
		return null;
	}

}
