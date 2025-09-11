package com.clothes_shop.clothes_shop.service;

import com.clothes_shop.clothes_shop.domain.User;
import com.clothes_shop.clothes_shop.dto.UpdateUserDto;
import com.clothes_shop.clothes_shop.dto.CreateUserDto;

import java.util.List;

public interface AdminService {
    List<User> getUsers();
    User registerUser(CreateUserDto dto);
    User updateUser(int id, UpdateUserDto dto);
    String deleteUserById(int id);
    User getUserById(int id);
}
