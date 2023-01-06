package com.example.ecommercebackend.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_sequence")
    @SequenceGenerator(name = "cart_sequence", allocationSize = 1)
    private int id;

    @NotNull(message = "productId cannot be empty")
    @Column(nullable = false, length = 20)
    int productId;
    @Column(nullable = false, length = 20)
    int quantity;
}
