package com.app.service;

import org.springframework.stereotype.Service;

import com.app.model.Cart;

import lombok.Data;

@Data
@Service
public class CartServiceImpl implements CartService{


	@Override
	public Cart addToCart(Cart cart, String token) {
		return cart;
		// TODO Auto-generated method stub
		
	}

}
