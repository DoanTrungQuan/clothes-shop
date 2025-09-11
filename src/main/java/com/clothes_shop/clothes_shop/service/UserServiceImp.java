package com.clothes_shop.clothes_shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clothes_shop.clothes_shop.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
