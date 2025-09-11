package com.clothes_shop.clothes_shop.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;
import com.clothes_shop.clothes_shop.service.UserService;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

    private final UserService userServiceImp;

    public UserController(UserService userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @GetMapping("/csrf")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

}
