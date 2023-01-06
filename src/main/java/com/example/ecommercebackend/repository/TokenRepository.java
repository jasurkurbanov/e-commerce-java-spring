package com.example.ecommercebackend.repository;

import com.example.ecommercebackend.entity.AuthenticationToken;
import com.example.ecommercebackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<AuthenticationToken, Integer> {

    AuthenticationToken findByUser(User user);

}
