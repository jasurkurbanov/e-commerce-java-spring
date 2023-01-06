package com.example.ecommercebackend.exceptions;

public class AuthenticationFailException extends IllegalArgumentException {

    public AuthenticationFailException(String msg){
        super(msg);
    }
}
