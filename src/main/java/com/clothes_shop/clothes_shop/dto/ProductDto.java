package com.clothes_shop.clothes_shop.dto;

import com.clothes_shop.clothes_shop.domain.Category;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.PositiveOrZero;
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
    @PositiveOrZero(message = "Price must be greater than or equals 0")
    private Double price;

    @Nullable
    private String urlPhoto;

    @Nullable
    private String hashtagCategory;
}
