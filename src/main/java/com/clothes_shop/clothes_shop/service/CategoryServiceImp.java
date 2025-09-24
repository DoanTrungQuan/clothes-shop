package com.clothes_shop.clothes_shop.service;

import com.clothes_shop.clothes_shop.common.EError;
import com.clothes_shop.clothes_shop.domain.Category;
import com.clothes_shop.clothes_shop.dto.CategoryDto;
import com.clothes_shop.clothes_shop.exception.BadRequestException;
import com.clothes_shop.clothes_shop.exception.NotFoundException;
import com.clothes_shop.clothes_shop.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Category createCategory(CategoryDto dto) {
        Optional<Category> category = this.categoryRepository.findByName(dto.getName());
        if (category.isPresent()) {
            throw new BadRequestException(EError.CATEGORY_EXISTED);
        }
        Category newCategory = new Category();
        newCategory.setName(dto.getName());
        return this.categoryRepository.save(newCategory);
    }

    @Override
    public Category updateCategoryById(Long id, CategoryDto dto) {
        Category category = this.getCategoryById(id);
        category.setName(dto.getName());
        return this.categoryRepository.save(category);
    }

    @Override
    public String deleteCategoryById(Long id) {
        Category category = this.getCategoryById(id);
        this.categoryRepository.delete(category);
        return "Successfully deleted";
    }

    @Override
    public String deleteCategoryByName(String name) {
        Category category = this.getCategoryByName(name);
        this.categoryRepository.delete(category);
        return "Successfully deleted";
    }
}
