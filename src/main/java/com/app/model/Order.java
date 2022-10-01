//package com.app.model;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.CollectionTable;
//import javax.persistence.ElementCollection;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
//import javax.validation.constraints.NotNull;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class Order {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Integer orderId;
//	
//	private LocalDate orderDate;
//	
//	private String orderStatus;
//	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "customer_id", referencedColumnName = "customerId")
//	private Customer customer;
//	
//	@ElementCollection
//	@CollectionTable(name="product_order", joinColumns = @JoinColumn(name="p_order_id", referencedColumnName = "orderId"))
//	private List<Product> productList = new ArrayList<>();
//	
//	@NotNull( message = "Enter delivery address!" )
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "order_id", referencedColumnName = "orderId")
//	private Address address;
//	
//	
//	
//	
//}
//
//
