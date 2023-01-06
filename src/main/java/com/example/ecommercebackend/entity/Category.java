package com.example.ecommercebackend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_sequence")
    @SequenceGenerator(name = "category_sequence", allocationSize = 1)
    private int id;


    @NotNull(message = "Name cannot be empty")
    @Size(min = 5, max = 20, message = "Name should be between 5 to 20 characters")
    @Column(nullable = false, unique = true, length = 20)
    private String name;
    @Column(nullable = false, length = 40)
    String imageUrl;
    @Column(nullable = false, length = 200)
    String description;

}
