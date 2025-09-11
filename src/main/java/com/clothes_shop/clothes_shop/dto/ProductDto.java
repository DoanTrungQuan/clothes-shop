package com.clothes_shop.clothes_shop.dto;

import com.clothes_shop.clothes_shop.domain.Color;
import jakarta.annotation.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

public class ProductDto {

    @Nullable
    private String name;

    @Nullable
    private String description;

    @Nullable
    private double price;

    @Nullable
    private int quantity;

    @Nullable
    private String urlPhoto;

    @Nullable
    private List<Color> colors = new ArrayList<Color>();


}
