package com.example.ecommercebackend.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tokens")
public class AuthenticationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authentication_sequence")
    @SequenceGenerator(name = "authentication_sequence", allocationSize = 1)
    private int id;

    @NotNull(message = "token cannot be empty")
    @Column(nullable = false, length = 50)
    private String token;

    @Column(nullable = false, length = 40)
    private Date createdDate;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    public AuthenticationToken(User user) {
        this.user = user;
        this.createdDate = new Date();
        this.token = UUID.randomUUID().toString();

    }

}
