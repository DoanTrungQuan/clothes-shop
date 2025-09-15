package com.clothes_shop.clothes_shop.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hashtag_categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HashtagCategory extends BaseEntity{

    @Column()
    private String hashtagCategory;

    @ManyToOne()
    @JoinColumn(name = "categories_id")
    private Category category;

    @OneToMany(mappedBy = "hashtagCategory", cascade = CascadeType.ALL,  fetch = FetchType.LAZY )
    private List<Product> products = new ArrayList<>();
}
