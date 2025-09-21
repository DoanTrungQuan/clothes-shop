package com.clothes_shop.clothes_shop.repository;

import com.clothes_shop.clothes_shop.domain.HashtagCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HashtagCategoryRepository extends JpaRepository<HashtagCategory,Long> {
    @Query(value = "SELECT * FROM hashtag_categories  WHERE name = :name", nativeQuery = true)
    HashtagCategory findByName(@Param("name") String name);
}
