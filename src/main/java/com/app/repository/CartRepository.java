package com.app.repository;

import com.app.model.Cart;
import com.app.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer>{

    List<Cart> findAllByUserOrderByCreatedDataDesc(User user);
}
