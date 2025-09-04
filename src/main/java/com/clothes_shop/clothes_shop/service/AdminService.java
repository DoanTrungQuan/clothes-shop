package com.clothes_shop.clothes_shop.service;

import com.clothes_shop.clothes_shop.common.CommonResponse;
import com.clothes_shop.clothes_shop.domain.User;
import com.clothes_shop.clothes_shop.dto.UserDto;

import java.util.List;

public interface AdminService {
    CommonResponse<List<User>> getUser();
    User registerUser(UserDto dto);

}
