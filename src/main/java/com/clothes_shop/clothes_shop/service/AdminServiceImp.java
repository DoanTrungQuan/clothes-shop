package com.clothes_shop.clothes_shop.service;

import com.clothes_shop.clothes_shop.common.CommonResponse;
import com.clothes_shop.clothes_shop.common.EError;
import com.clothes_shop.clothes_shop.domain.User;
import com.clothes_shop.clothes_shop.dto.UserDto;
import com.clothes_shop.clothes_shop.exception.BadRequestException;
import com.clothes_shop.clothes_shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImp implements AdminService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public AdminServiceImp(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public CommonResponse<List<User>> getUser() {
        List<User> users = this.userRepository.findAll();
        return CommonResponse.response(
                "success",
                HttpStatus.OK.value(),
                users
        );
    }

    @Override
    public User registerUser(UserDto userDto) {
        User existUser = this.userRepository.findByUserName(userDto.getUserName());
        if (existUser != null) {
            throw new BadRequestException(EError.USER_EXISTED);
        }
        User newUser = new User();
        newUser.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        newUser.setUserName(userDto.getUserName());
        newUser.setEmail(userDto.getEmail());
        return userRepository.save(newUser);
    }
}
