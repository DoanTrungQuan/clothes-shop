package com.clothes_shop.clothes_shop.controller;

import com.clothes_shop.clothes_shop.domain.Category;
import com.clothes_shop.clothes_shop.dto.CategoryDto;
import com.clothes_shop.clothes_shop.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getCategories(){
        List<Category> categories = categoryService.getCategories();
        return ResponseEntity.ok().body(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") Long id){
        Category category = categoryService.getCategoryById(id);
        return ResponseEntity.ok().body(category);
    }

    @GetMapping()
    public ResponseEntity<Category> getCategoryByName(@RequestParam String name){
        Category category = categoryService.getCategoryByName(name);
        return ResponseEntity.ok().body(category);
    }

    @PostMapping("/create")
    public ResponseEntity<Category> createCategory(@RequestBody CategoryDto dto){
        Category category = categoryService.createCategory(dto);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Category> updateCategoryById(@PathVariable Long id, @RequestBody CategoryDto dto){
        Category category = categoryService.updateCategoryById(id, dto);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable Long id){
        String message = categoryService.deleteCategoryById(id);
        return ResponseEntity.ok().body(message);
    }

    @DeleteMapping("delete")
    public ResponseEntity<String> deleteCategoryByName(@RequestParam String name){
        String message = categoryService.deleteCategoryByName(name);
        return ResponseEntity.ok().body(message);
    }
}
