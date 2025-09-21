package com.clothes_shop.clothes_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clothes_shop.clothes_shop.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String userName);
}
