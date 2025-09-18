package com.clothes_shop.clothes_shop.service;

import com.clothes_shop.clothes_shop.common.Error;
import com.clothes_shop.clothes_shop.domain.User;
import com.clothes_shop.clothes_shop.dto.UpdateUserDto;
import com.clothes_shop.clothes_shop.dto.CreateUserDto;
import com.clothes_shop.clothes_shop.exception.BadRequestException;
import com.clothes_shop.clothes_shop.exception.NotFoundException;
import com.clothes_shop.clothes_shop.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImp implements AdminService {

    private final UserRepository userRepository;

    public AdminServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        List<User> users = this.userRepository.findAll();
        return users;
    }

    @Override
    public User registerUser(CreateUserDto createUserDto) {
        User existUser = this.userRepository.findByUserName(createUserDto.getUserName());
        if (existUser != null) {
            throw new BadRequestException(Error.USER_EXISTED);
        }
        User newUser = new User();
        newUser.setPassword(createUserDto.getPassword());
        newUser.setUserName(createUserDto.getUserName());
        newUser.setEmail(createUserDto.getEmail());
        return userRepository.save(newUser);
    }

    public User updateUserFromDto(User existedUser, UpdateUserDto dto) {
        if (dto.getPassword() != null) {
            existedUser.setPassword(dto.getPassword());
        }
        if (dto.getEmail() != null) {
            existedUser.setEmail(dto.getEmail());
        }
        if (dto.getUserName() != null) {
            existedUser.setUserName(dto.getUserName());
        }
        if (dto.getAddress() != null) {
            existedUser.setAddress(dto.getAddress());
        }
        if (dto.getDateOfBirth() != null) {
            existedUser.setDateOfBirth(dto.getDateOfBirth());
        }
        if (dto.getPhoneNumber() != null) {
            existedUser.setPhoneNumber(dto.getPhoneNumber());
        }
        return existedUser;
    }

    @Override
    public User updateUser(int id, UpdateUserDto dto) {
        User existedUser = this.userRepository.findById(id);
        if (existedUser == null) {
            throw new NotFoundException(Error.USER_NOT_FOUND);
        }
        existedUser = updateUserFromDto(existedUser, dto);
        return this.userRepository.save(existedUser);
    }

    @Override
    public String deleteUserById(int id) {
        User existedUser = this.userRepository.findById(id);
        if (existedUser == null) {
            throw new NotFoundException(Error.USER_NOT_FOUND);
        }
        userRepository.delete(existedUser);
        return "User Deleted Successfully";
    }

    @Override
    public User getUserById(int id) {
        User existedUser = this.userRepository.findById(id);
        if (existedUser == null) {
            throw new NotFoundException(Error.USER_NOT_FOUND);
        }
        return existedUser;
    }


}
