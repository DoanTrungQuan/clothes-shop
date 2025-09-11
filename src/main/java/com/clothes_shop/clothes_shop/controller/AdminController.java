package com.clothes_shop.clothes_shop.controller;

import com.clothes_shop.clothes_shop.domain.User;
import com.clothes_shop.clothes_shop.dto.CreateUserDto;
import com.clothes_shop.clothes_shop.dto.UpdateUserDto;
import com.clothes_shop.clothes_shop.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }


    @GetMapping("/users")
    public List<User> getUsers() {
        return this.adminService.getUsers();
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody CreateUserDto createUserDto) {
        User user = this.adminService.registerUser(createUserDto);
        return ResponseEntity.ok(user);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") int id,
                                           @RequestBody UpdateUserDto updateUserDto) {
        return ResponseEntity.ok().body(this.adminService.updateUserInfo(id, updateUserDto));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable("id") int id) {

        return null;
    }

}
