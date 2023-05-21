package org.vegetableApp.controller.CartController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.vegetableApp.cart.model.Cart;
import org.vegetableApp.cart.service.CartService;
import org.vegetableApp.order.model.Order;
import org.vegetableApp.order.service.OrderServiceImpl;
import org.vegetableApp.user.model.User;
import org.vegetableApp.user.srevice.LoginServiceImpl;
import org.vegetableApp.vegetable.model.VegetableDTO;
import org.vegetableApp.vegetable.service.VegetableServiceImpl;


@Controller
@RequestMapping("/cart")
@SessionAttributes("userid")
public class CartController {
	@Autowired
	private LoginServiceImpl loginService;
	
	@Autowired
	private VegetableServiceImpl vegetableService;
	
	@Autowired
	private OrderServiceImpl OrderService;
	
	@Autowired
	private CartService cartService;
	
	
	
	private Order order = new Order();
	
	@GetMapping("/addtocart")
	public String addToCart(@RequestParam("vegetableid")Integer vegId, Model model) {
		
		Integer userid = (Integer) model.getAttribute("userid");
		User user = loginService.getUserByUserId(userid);
		
		Cart cart = user.getCart();
		
		VegetableDTO vegetable = vegetableService.viewVegetableById(vegId);
		model.addAttribute("vegetable",vegetable);
		
		cart.getVegList().add(vegetable);
		
		cartService.addCart(cart);
		model.addAttribute("cart",cart);
		
		return "cart/addtocart";
		
	}
	
	
	
	@GetMapping("/viewCart")
	public String viewCartItems(@RequestParam("cartid")Integer cartId,Model model) {
		Cart cart=cartService.getCartById(cartId);
		 List<VegetableDTO> vegList =cart.getVegList();
		 order.setCart(cart);
		model.addAttribute("order", order);
		OrderService.addOrder(order);
		for(VegetableDTO veg:vegList) {
			veg.setQuantity(1);
		}
		model.addAttribute("vegetable",vegList);
		return "cart/viewCart";
	}
	
	
	@GetMapping("/deleteItem")
	public String deleteItem(@RequestParam("vegetableid")Integer vegId, Model model) {
		Integer userid = (Integer) model.getAttribute("userid");
		User user=loginService.getUserByUserId(userid);
		Cart cart = user.getCart();
		VegetableDTO vegetable = vegetableService.viewVegetableById(vegId);
		Cart cartNew=cartService.removeItem(cart, vegetable);
		if(cartNew.getVegList()==null)
			return "cart/emptyCart";
		cartService.addCart(cartNew);
			model.addAttribute("cart", cartNew);
		return "cart/deleteItem";
	}
	
	
	@GetMapping("/orderDetails")
	public String orderDetails(@RequestParam("orderid")Integer orderId,Model model) {
		Integer userId=(Integer)model.getAttribute("userid");
		User user=loginService.getUserByUserId(userId);
		Cart cart=user.getCart();
		Order order=OrderService.findOrderById(orderId);
		order.setCart(cart);
		List<VegetableDTO> vegList=cart.getVegList();
		model.addAttribute("veg",vegList);
		Double total=0.0;
		for(VegetableDTO veg:vegList) {
			veg.setQuantity(1);
			total=total+(veg.getPrice()*veg.getQuantity());
		}
		order.setTotalAmount(total);
		model.addAttribute("order",order);
		OrderService.addOrder(order);
		return "cart/orderDetails";
		
	}
	
	
	@GetMapping("/orderPlaced")
	public String orderPlaced(@RequestParam("orderId")Integer orderId,Model model) {
		order = OrderService.findOrderById(orderId);
		order.setOrderStatus("Pending");
		OrderService.addOrder(order);
		return "cart/orderPlaced";
	}
	
	
	@GetMapping("/changeStatus")
	public String changeStatus(@RequestParam("orderId")Integer orderId,Model model) {
		order = OrderService.findOrderById(orderId);
		order.setOrderStatus("Accepted");
		OrderService.addOrder(order);
		model.addAttribute("order", order);
		return "cart/changeStatus";
	}
	

}
