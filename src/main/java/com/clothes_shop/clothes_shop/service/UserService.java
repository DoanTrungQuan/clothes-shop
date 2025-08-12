package com.clothes_shop.clothes_shop.service;

import com.clothes_shop.clothes_shop.domain.User;

public interface UserService {
    String getUser(int id);
    User createUser(User user);
}
