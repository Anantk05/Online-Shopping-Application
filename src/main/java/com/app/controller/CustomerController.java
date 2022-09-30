package com.app.controller;

import java.util.List;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.exceptions.CustomerException;
import com.app.model.Customer;
import com.app.service.CustomerService;

public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/addcustomer")
	public ResponseEntity<Customer> addCustomerHandler(@RequestBody Customer customer) throws CustomerException{
		
		Customer addedCustomer = customerService.addCustomer(customer);
		
		 return new ResponseEntity<Customer>(addedCustomer, HttpStatus.CREATED);
		
	}
	
	@PutMapping("/updatecustomer/{key}")
	public ResponseEntity<Customer> updateCustomerHandler(@PathVariable("key") String key,@RequestBody Customer customer) throws LoginException, CustomerException{
		
		Customer updatedCustomer = customerService.updateCustomer(customer, key);
		
		return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/deletecustomer/{key}")
	public ResponseEntity<Customer> removeCustomerHandler(@PathVariable("key") String key,@RequestBody Customer customer) throws CustomerException{
		
		Customer deletedCustomer = customerService.removeCustomer(customer, key);
		
		return new ResponseEntity<Customer>(deletedCustomer, HttpStatus.OK);
		
	}
	
	@GetMapping("/getcustomer")
	public ResponseEntity<Customer> getCustomerHandler(@RequestBody Customer customer) throws CustomerException{
		
		Customer existingCustomer = customerService.viewCustomer(customer);
		
		return new ResponseEntity<Customer>(existingCustomer, HttpStatus.OK);
		
	}
	
	@GetMapping("/getallcustomers/{state}")
	public ResponseEntity<List<Customer>> getAllCustomersByLocation(@PathVariable("state") String state) throws CustomerException{
		
		List<Customer> customersByLocation = customerService.viewAllCustomer(state);
		
		return new ResponseEntity<List<Customer>>(customersByLocation, HttpStatus.OK);
		
	}

	
}
