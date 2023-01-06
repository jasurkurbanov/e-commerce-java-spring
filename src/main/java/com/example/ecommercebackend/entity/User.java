package com.example.ecommercebackend.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.example.ecommercebackend.enums.Roles;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
    @SequenceGenerator(name = "product_sequence", allocationSize = 1)
    int id;

    @NotNull(message = "First Name cannot be empty")
    @Size(min = 5, max = 20, message = "Name should be between 5 to 20 characters")
    @Column(nullable = false, length = 20)
    String firstName;

    @NotNull(message = "Last Name cannot be empty")
    @Size(min = 5, max = 20, message = "Name should be between 5 to 20 characters")
    @Column(nullable = false, length = 20)
    String lastName;

    @NotNull(message = "Email cannot be empty")
    @Column(nullable = false, unique = true, length = 40)
    String email;

    @NotNull(message = "Email cannot be empty")
    @Size(min = 6, max = 100, message = "Name should be between 6 to 20 characters")
    @Column(nullable = false, length = 100)
    String password;

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    @Enumerated(EnumType.STRING)
    private Roles roles;

}
