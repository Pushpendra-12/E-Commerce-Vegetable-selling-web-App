package org.vegetableApp.vegetable.model;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class VegetableDTO {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Integer vegId;
	private String vegName;
	private String vegType;
	private double price;
	private Integer quantity;

}
