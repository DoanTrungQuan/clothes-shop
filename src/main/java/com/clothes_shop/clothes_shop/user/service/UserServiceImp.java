package com.clothes_shop.clothes_shop.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clothes_shop.clothes_shop.user.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    public UserRepository userRepository;

    @Override
    public String getUser(int id) {
        return "Succes";
    }
}
