package com.app.controller;

import java.time.LocalDate;
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

import com.app.model.Order;
import com.app.service.OrderService;

public class OrderController {
    @Autowired
    private  OrderService orderService;
    
    @PostMapping("/addorder")
    public ResponseEntity<Order> addOrderHandler(@RequestBody Order order){
    	
    	Order addedOrder = null;
    	
    	return new ResponseEntity<Order>(addedOrder, HttpStatus.CREATED);
    }
    
    @PutMapping("/updateorder")
    public ResponseEntity<Order> updateOrderHandler(@RequestBody Order order){
    	
    	Order updatedOrder = null;
    	
    	return new ResponseEntity<Order>(updatedOrder, HttpStatus.CREATED);
    	
    }
    
    @DeleteMapping("/deleteorder")
    public ResponseEntity<Order> removeOrderHandler(@RequestBody Order order){
    	
    	Order deletedOrder = null;
    	
    	return new ResponseEntity<Order>(deletedOrder, HttpStatus.OK);
    	
    }
    
    @GetMapping("/vieworder")
    public ResponseEntity<Order> viewOrderHandler(@RequestBody Order order){
    	
    	Order existingOrder = null;
    	
    	return new ResponseEntity<Order>(existingOrder, HttpStatus.OK);
    	
    }
    
    @GetMapping("/getallorderr")
    public ResponseEntity<List<Order>> getAllOrdersBydateHandler(@RequestBody LocalDate date){
    	
    	List<Order> orders = null;
    	
    	return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
    	
    }
    
    @GetMapping("/getallorders/{state}")
    public ResponseEntity<List<Order>> getAllOrdersByLocationHandler(@PathVariable("state") String state){
    	
    	List<Order> orders = null;
    	
    	return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
    	
    }
    
    @GetMapping("/getallorders/{userId}")
    public ResponseEntity<List<Order>> getAllOrdersByUserIdHandler(@PathVariable("UserId") String userId){
    	
    	List<Order> orders = null;
    	
    	return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
    	
    }
    
    

}
