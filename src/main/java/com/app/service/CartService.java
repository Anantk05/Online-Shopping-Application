package com.app.service;

import com.app.dto.cart.AddToCartDto;
import com.app.dto.cart.CartDto;
import com.app.model.User;

public interface CartService {


    void addToCart(AddToCartDto addToCartDto, User user);

    CartDto listCartItems(User user);
}
