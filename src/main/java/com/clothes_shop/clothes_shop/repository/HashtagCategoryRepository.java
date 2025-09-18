package com.clothes_shop.clothes_shop.repository;

import com.clothes_shop.clothes_shop.domain.HashtagCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HashtagCategoryRepository extends JpaRepository<HashtagCategory,Integer> {
}
