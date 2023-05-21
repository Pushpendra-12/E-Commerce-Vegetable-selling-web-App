package org.vegetableApp.order.model;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;
import org.vegetableApp.cart.model.Cart;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer orderId;
	private LocalDateTime orderDate;
	
	@OneToOne
	private Cart cart;
	
	private String orderStatus;
	
	private Double totalAmount;

}
