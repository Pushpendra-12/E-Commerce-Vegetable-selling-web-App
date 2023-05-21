package org.vegetableApp.order.service;

import org.springframework.stereotype.Service;
import org.vegetableApp.order.model.Order;

@Service
public interface OrderService {
	public Order addOrder(Order order);
	public Order findOrderById(Integer orderId);
	
//	public OrderDetails updateOrder(OrderDetails order);
//	public OrderDetails removeOrder(OrderDetails order);
//	public OrderDetails viewOrder(OrderDetails order);
//	public List<OrderDetails> viewAllOrders(Restaurant res);
//	public List<OrderDetails> viewAllOrders(Customer customer);

}
