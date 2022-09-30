package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.model.Customer;
import com.app.service.CustomerService;

public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/addcustomer")
	public ResponseEntity<Customer> addCustomerHandler(@RequestBody Customer customer){
		
		Customer addedCustomer = null;
		
		 return new ResponseEntity<Customer>(addedCustomer, HttpStatus.CREATED);
		
	}
	
	@PutMapping("/updatecustomer")
	public ResponseEntity<Customer> updateCustomerHandler(@RequestBody Customer customer){
		
		Customer updatedCustomer = null;
		
		return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/deletecustomer")
	public ResponseEntity<Customer> removeCustomerHandler(@RequestBody Customer customer){
		
		Customer deletedCustomer = null;
		
		return new ResponseEntity<Customer>(deletedCustomer, HttpStatus.OK);
		
	}
	
	@GetMapping("/getcustomer")
	public ResponseEntity<Customer> getCustomerHandler(@RequestBody Customer customer){
		
		Customer existingCustomer = null;
		
		return new ResponseEntity<Customer>(existingCustomer, HttpStatus.OK);
		
	}
	
	@GetMapping("/getallcustomers/{state}")
	public ResponseEntity<List<Customer>> getAllCustomersByLocation(@PathVariable("state") String state){
		
		List<Customer> customersByLocation = null;
		
		return new ResponseEntity<List<Customer>>(customersByLocation, HttpStatus.OK);
		
	}

	
}
