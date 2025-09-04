package com.clothes_shop.clothes_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clothes_shop.clothes_shop.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserName(String userName);
}
