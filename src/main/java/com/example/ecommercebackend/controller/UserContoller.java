package com.example.ecommercebackend.controller;

import com.example.ecommercebackend.dto.responses.ResponseDto;
import com.example.ecommercebackend.dto.responses.SignInResponseDto;
import com.example.ecommercebackend.dto.user.SignInDto;
import com.example.ecommercebackend.dto.user.SignUpDto;
import com.example.ecommercebackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserContoller {
    @Autowired
    private UserService userService;

    @PostMapping("/signUp")
    public ResponseDto signUp(@RequestBody SignUpDto signUpDto) {
        return userService.signUp(signUpDto);
    }

    @PostMapping("/signIn")
    public SignInResponseDto signIn(@RequestBody SignInDto signInDto) {
        return userService.signIn(signInDto);
    }
}
