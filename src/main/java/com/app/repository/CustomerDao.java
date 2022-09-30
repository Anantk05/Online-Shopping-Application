package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Customer;


public interface CustomerDao extends JpaRepository<Customer, Integer> {

	public Optional<Customer> findByMobileNumber(String mobileNumber) ;
	
}
