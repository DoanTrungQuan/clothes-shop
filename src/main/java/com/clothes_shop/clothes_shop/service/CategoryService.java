package com.clothes_shop.clothes_shop.service;

import com.clothes_shop.clothes_shop.domain.Category;
import com.clothes_shop.clothes_shop.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories();
    Category getCategoryById(Long id);
    Category getCategoryByName(String name);
    Category createCategory(CategoryDto dto);
    Category updateCategoryById(Long id, CategoryDto dto);
    String deleteCategoryById(Long id);
    String deleteCategoryByName(String name);
}
