package com.example.ecommercebackend.controller;

import com.example.ecommercebackend.entity.WishList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/wishlist")
public class WishListController {

    @GetMapping
    public void getWishlist(){
        // token
        return;
    }

    @PostMapping("/add")
    public void addWishList(WishList wishList){
        // token
        return;
    }
}
