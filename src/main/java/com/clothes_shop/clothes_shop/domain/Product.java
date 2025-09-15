package com.clothes_shop.clothes_shop.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseEntity {
    @Column(nullable = true)
    private String name;

    @Column(nullable = true)
    private String description;

    @Column(nullable = true)
    private Double price;

    @Column(nullable = true)
    private String urlPhoto;

    @ManyToOne()
    @JoinColumn(name = "hashtag_categories_id")
    private HashtagCategory hashtagCategory;

    @Column(nullable = true)
    private String size;

    @Column(nullable = true)
    private String productCode;

    @Column(nullable = true)
    private boolean isFavorite;

    @ManyToMany(mappedBy = "products")
    private List<User> users = new ArrayList<>();
}
