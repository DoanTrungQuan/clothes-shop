package com.clothes_shop.clothes_shop.dto;

import com.clothes_shop.clothes_shop.domain.Color;
import jakarta.annotation.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    @Nullable
    private String name;

    @Nullable
    private String description;

    @Nullable
    private Double price;

    @Nullable
    private Integer quantity;

    @Nullable
    private String urlPhoto;

    @Nullable
    private List<Color> colors = new ArrayList<Color>();


}
