package com.clothes_shop.clothes_shop.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "colors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Color extends BaseEntity{
    @Column(nullable = true)
    private String color;

    @Column(nullable = true)
    private String description;

    @Column(nullable = true)
    private String url;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;
}
