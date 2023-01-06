package com.example.ecommercebackend.controller;

import com.example.ecommercebackend.entity.Category;
import com.example.ecommercebackend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public Category getAllCategories(Category category){
        return  categoryService.createCategory(category);
    }

    @PostMapping("/add")
    public Category createCategory(@RequestBody  Category category){
        return  categoryService.createCategory(category);
    }

    @PutMapping("/update/{id}")
    public Category updateCategory(@PathVariable int id, @RequestBody  Category category){
        return  categoryService.updateCategory(id, category);
    }



}
