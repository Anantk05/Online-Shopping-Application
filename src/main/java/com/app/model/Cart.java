package com.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "customer_id", referencedColumnName = "customerId")
	private Customer customer;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "carts_product", joinColumns = @JoinColumn(name="cart_id", referencedColumnName = "cartId"))
	private List<Product> products;

	
	
	

}
