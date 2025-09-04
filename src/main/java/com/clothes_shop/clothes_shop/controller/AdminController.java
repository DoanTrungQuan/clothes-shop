package com.clothes_shop.clothes_shop.controller;

import com.clothes_shop.clothes_shop.common.CommonResponse;
import com.clothes_shop.clothes_shop.domain.User;
import com.clothes_shop.clothes_shop.dto.UserDto;
import com.clothes_shop.clothes_shop.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }


    @GetMapping("/users")
    public CommonResponse<List<User>> getUser() {
        return this.adminService.getUser();
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserDto userDto) {
        User user = this.adminService.registerUser(userDto);
        return ResponseEntity.ok(user);
    }

}
