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
    private Integer quantity;

    @Column(nullable = true)
    private String urlPhoto;

    @Column(nullable = true)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Color> colors = new ArrayList<Color>();

}
