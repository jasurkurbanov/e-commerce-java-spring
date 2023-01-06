package com.example.ecommercebackend.service;

import com.example.ecommercebackend.dto.responses.ResponseDto;
import com.example.ecommercebackend.dto.responses.SignInResponseDto;
import com.example.ecommercebackend.dto.user.SignInDto;
import com.example.ecommercebackend.dto.user.SignUpDto;
import com.example.ecommercebackend.entity.AuthenticationToken;
import com.example.ecommercebackend.entity.User;
import com.example.ecommercebackend.exceptions.AuthenticationFailException;
import com.example.ecommercebackend.exceptions.CustomException;
import com.example.ecommercebackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationService authenticationService;


    // sign up
    // if token is not saved, we will revert newly created user
    // rollback a transaction
    @Transactional
    public ResponseDto signUp(SignUpDto signUpDto) {
       
        // check if user exist
        if(Objects.nonNull(userRepository.findByEmail(signUpDto.getEmail()))){
            throw new CustomException("user already present");
        }

        // hash password

        String encryptedPassword = signUpDto.getPassword();
        try {
            encryptedPassword = hashPassword(signUpDto.getPassword());
        } catch (NoSuchAlgorithmException e) {
            // for java security exception
            throw new RuntimeException(e);
        }

        // save user
        User user = new User(signUpDto.getFirstName(), signUpDto.getLastName(), signUpDto.getEmail(), encryptedPassword);
        userRepository.save(user);

        // create token
        final AuthenticationToken authenticationToken =  new AuthenticationToken(user);
        authenticationService.saveConfirmationToken(authenticationToken);

        // response to client
        ResponseDto responseDto = new ResponseDto("success", "user created successfully");
        return responseDto;
    }

    // TODO: folder for helpers ?
    private String hashPassword(String password) throws NoSuchAlgorithmException {
        // java security
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String hash = DatatypeConverter.printHexBinary(digest).toUpperCase();
        return hash;
    }

    public SignInResponseDto signIn(SignInDto signInDto){

        // find user by email
        User user = userRepository.findByEmail(signInDto.getEmail());

        if(Objects.isNull(user)){
            throw new AuthenticationFailException("user is not found");
        }
        // hash the password && compare the password in DB
        try {
            if(!user.getPassword().equals(hashPassword(signInDto.getPassword()))){
                throw  new AuthenticationFailException("wrong password");
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        // if password match
        // retrieve token
        AuthenticationToken token = authenticationService.getToken(user);

        if(Objects.isNull(token)){
            throw new CustomException("token is not present");
        }

        return new SignInResponseDto("success", token.getToken());
    }
}
