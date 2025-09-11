package com.clothes_shop.clothes_shop.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
