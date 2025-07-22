package com.clothes_shop.clothes_shop.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.clothes_shop.clothes_shop.user.service.UserService;

@RestController
@RequestMapping()
public class UserController {

    @Autowired
    private UserService userServiceImp;

    @GetMapping("{id}")
    public String getUser(@PathVariable int id) {
        return userServiceImp.getUser(id);
    }
    @GetMapping()
    public String get(){
        return "AA";
    }
}
