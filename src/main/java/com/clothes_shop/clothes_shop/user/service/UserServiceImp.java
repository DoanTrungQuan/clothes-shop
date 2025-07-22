package com.clothes_shop.clothes_shop.user.service;

import com.clothes_shop.clothes_shop.exception.BadRequestException;
import com.clothes_shop.clothes_shop.exception.NotFoundException;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import com.clothes_shop.clothes_shop.user.repository.UserRepository;

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
}
