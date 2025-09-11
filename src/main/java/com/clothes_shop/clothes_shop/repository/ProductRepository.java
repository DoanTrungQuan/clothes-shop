package com.clothes_shop.clothes_shop.repository;

import com.clothes_shop.clothes_shop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByName(String name);
}
