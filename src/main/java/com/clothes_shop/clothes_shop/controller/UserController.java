package com.clothes_shop.clothes_shop.controller;

import com.clothes_shop.clothes_shop.domain.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;
import com.clothes_shop.clothes_shop.service.UserService;

@RestController
@RequestMapping(path = "api/user")
public class UserController {

    @Autowired
    private UserService userServiceImp;

    @GetMapping
    public String welcome(){
        return "Welcome";
    }
    @GetMapping("{id}")
    public String getUser(@PathVariable int id) {
        return userServiceImp.getUser(id);
    }
    @GetMapping("csrf")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping()
    public ResponseEntity<User>  createUser(@RequestBody User user){
        User newUser = userServiceImp.createUser(user);
        return ResponseEntity.ok(newUser);
    }
}
