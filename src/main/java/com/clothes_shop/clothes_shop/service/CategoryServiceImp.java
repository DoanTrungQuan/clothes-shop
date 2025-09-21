package com.clothes_shop.clothes_shop.service;

import com.clothes_shop.clothes_shop.common.EError;
import com.clothes_shop.clothes_shop.domain.Category;
import com.clothes_shop.clothes_shop.exception.NotFoundException;
import com.clothes_shop.clothes_shop.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImp(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getCategories() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        Category category = this.categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(EError.CATEGORY_NOT_FOUND));
        return category;
    }

    @Override
    public Category getCategoryByName(String name) {
        Category category = this.categoryRepository.findByName(name)
                .orElseThrow(() -> new NotFoundException(EError.CATEGORY_NOT_FOUND));
        return category;
    }

    @Override
    public Category createCategory(Category category) {
        return null;
    }

    @Override
    public Category updateCategory(Category category) {
        return null;
    }

    @Override
    public String deleteCategoryById(Long id) {
        return "";
    }

    @Override
    public String deleteCategoryByName(String name) {
        return "";
    }
}
