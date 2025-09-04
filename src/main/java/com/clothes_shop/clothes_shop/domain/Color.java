package com.clothes_shop.clothes_shop.domain;


import jakarta.persistence.*;

@Entity
@Table(name = "colors")
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

    public Color(String color, String description, String url) {
        this.color = color;
        this.description = description;
        this.url = url;
    }

    public Color() {

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
