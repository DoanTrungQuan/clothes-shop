package com.clothes_shop.clothes_shop.service;

import com.clothes_shop.clothes_shop.domain.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories();
    Category getCategoryById(Long id);
    Category getCategoryByName(String name);
    Category createCategory(Category category);
    Category updateCategory(Category category);
    String deleteCategoryById(Long id);
    String deleteCategoryByName(String name);
}
