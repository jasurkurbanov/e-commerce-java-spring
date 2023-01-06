package com.example.ecommercebackend.service;

import com.example.ecommercebackend.repository.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishListService {
    @Autowired
    private WishListRepository wishListRepository;
}
