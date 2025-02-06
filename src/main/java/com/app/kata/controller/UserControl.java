package com.app.kata.controller;

import com.app.kata.entity.Users;
import com.app.kata.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserControl {
    @Autowired
    private UsersService usersService;

    @PostMapping("/signin")
    public ResponseEntity<Users> createUser(@RequestBody Users user){
        Users newUser =usersService.createUser(user);
        return new ResponseEntity<>(newUser,HttpStatus.CREATED);
    }

    @GetMapping("/login")
    public ResponseEntity<Users> getUser(@RequestParam(name = "correo") String correo, @RequestParam(name = "pwd")String password){
        Users infoUser = usersService.logIn(correo,password);
        return new ResponseEntity<>(infoUser, HttpStatus.OK);
    }
}
