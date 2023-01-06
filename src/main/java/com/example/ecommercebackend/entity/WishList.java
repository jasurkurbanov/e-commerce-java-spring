package com.example.ecommercebackend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "wishlist")
public class WishList {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
    @SequenceGenerator(name = "product_sequence", allocationSize = 1)
    int id;

    @NotNull(message = "Name cannot be empty")
    @Size(min = 5, max = 20, message = "Name should be between 5 to 20 characters")
    @Column(nullable = false, length = 20)
    String name;
    @Column(nullable = false, length = 40)
    String imageUrl;
    @Column(nullable = false, length = 20)
    int price;
    @Column(nullable = false, length = 200)
    String description;


}
