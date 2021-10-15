package com.example.demo.controller;

import javax.validation.Valid;
import com.example.demo.model.UserEntity;
import com.example.demo.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody @Valid UserEntity userEntity){

        UserEntity userEntity22 = userService.createUser(userEntity);

        return  ResponseEntity.status(HttpStatus.OK).body(userEntity22);
    }


    @GetMapping
    public ResponseEntity<UserEntity> getUser(){

        UserEntity userEntity = userService.getUser();

        return ResponseEntity.status(HttpStatus.OK).body(userEntity);
    }
}
