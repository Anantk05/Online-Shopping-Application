package com.app.service;

import com.app.model.Cart;

public interface CartService {


    public Cart addToCart(Cart cart, String token);

//    CartDto listCartItems(User user);
}
