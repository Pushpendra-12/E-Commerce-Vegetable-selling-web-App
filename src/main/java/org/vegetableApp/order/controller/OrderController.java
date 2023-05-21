package org.vegetableApp.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.vegetableApp.order.model.Order;
import org.vegetableApp.order.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	
	@GetMapping("/addorder")
	public String addOrder(Model model) {
		Order order=new Order();
		model.addAttribute(order);
		return "order/addorder";

}
	
	@PostMapping("/addorder")
	public String addItemProcess(@ModelAttribute("order") Order order) {
		
		orderService.addOrder(order);
		return "order/addsuccess";
	
}

}
