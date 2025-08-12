package com.clothes_shop.clothes_shop.service;

import com.clothes_shop.clothes_shop.exception.NotFoundException;
import com.clothes_shop.clothes_shop.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clothes_shop.clothes_shop.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    public UserRepository userRepository;

    @Override
    public String getUser(int id) {
        if (userRepository.findById(id).isEmpty()) {
            throw new NotFoundException("User not found");
        }
        return "A";
    }
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
