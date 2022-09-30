package com.app.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.exceptions.OrderException;
import com.app.model.Address;
import com.app.model.Order;
@Repository
public interface OrderDao extends JpaRepository<Order, Integer>{
	@Query("select o from Order o where o.orderDate= ?1")
	public List<Order> viewAllOrders(LocalDate date) throws OrderException ;
	
	@Query("select d from Order d where d.address= ?1")
	public List<Order> viewAllorderByAddress(Address address) throws OrderException;
	

}
