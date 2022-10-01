package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Cart;
import com.app.model.User;
import com.app.service.CartService;

import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/com/app/dto/cart")
public class CartController {

    @Autowired
    private CartService cartService;




    @PostMapping("/add")
    public ResponseEntity<Cart> addToCart(@RequestBody Cart cart,
                                                 @RequestParam("token") String token){


        // find the user

   


        Cart cartItem = cartService.addToCart(cart, token );

        return new ResponseEntity<>(cartItem, HttpStatus.CREATED);
    }

//
//
//    @GetMapping("/")
//    public ResponseEntity<CartDto> getCartItems(@RequestParam("token") String token) {
//
//        authenticationService.authenticate(token);
//        User user = authenticationService.getUser(token);
//        CartDto cartDto = cartService.listCartItems(user);
//        return new ResponseEntity<>(cartDto, HttpStatus.OK);
//    }
//
//    // delete a cart item for a user
//
//    @DeleteMapping("/delete/{cartItemId}")
//    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable("cartItemId") Integer itemId,
//                                                      @RequestParam("token") String token) {
//
//       
//        authenticationService.authenticate(token);
//
//       
//        User user = authenticationService.getUser(token);
//
//        cartService.deleteCartItem(itemId, user);
//
//        return new ResponseEntity<>(new ApiResponse(true, "Item has been removed"), HttpStatus.OK);
//
//    }

}
