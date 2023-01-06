package com.example.ecommercebackend.controller;

import com.example.ecommercebackend.entity.Cart;
import com.example.ecommercebackend.repository.CartRepository;
import com.example.ecommercebackend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping
    public void getCartItems(){
        //token
        return;
    }

    @PostMapping("/add")
    public void addToCart(@RequestBody Cart cart){
        //token
        return;
    }


    @DeleteMapping("/delete/{id}")
    public void deleteCartItem(@PathVariable int id){
        //token
        return;
    }


    @PutMapping("/update/{id}")
    public void updateCartItem(@PathVariable int id){
        //token
        return;
    }
}
