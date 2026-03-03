package com.apad99.JobBoard.controller;

import org.springframework.web.bind.annotation.RestController;

import com.apad99.JobBoard.model.User;
import com.apad99.JobBoard.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UserController {
    
    @Autowired
    private UserService service;

    @PostMapping("register")
    public User register(@RequestBody User user) {
        
        return service.saveUser(user);
    }
    
}
