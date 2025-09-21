package com.clothes_shop.clothes_shop.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Column()
    private double price;

    @Column(nullable = true)
    private String urlPhoto;

    @ManyToOne()
    @JoinColumn(name = "hashtag_categories_id")
    private HashtagCategory hashtagCategory;

    @Column(name = "product_code", nullable = true)
    private String productCode;

    @Transient
    private boolean isFavorite;

    @OneToMany(mappedBy = "product")
    private Set<Order> orders = new HashSet<>();

    @OneToMany(mappedBy = "product")
    private List<ShoppingCart> carts = new ArrayList<>();
}
