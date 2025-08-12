package com.clothes_shop.clothes_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clothes_shop.clothes_shop.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
