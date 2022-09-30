package com.app.model;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartId;
	
	@NotNull(message = "Login first...")
	@Embedded
	private Customer customer;
	
	private List<Product> productList;

	
	
	public Cart(@NotNull(message = "Login first...") Customer customer, List<Product> productList) {
		super();
		this.customer = customer;
		this.productList = productList;
	}
	
	
	

}
