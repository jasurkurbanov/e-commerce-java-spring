package com.example.ecommercebackend.service;

import com.example.ecommercebackend.entity.Category;
import com.example.ecommercebackend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }

    public Category updateCategory(int id, Category category){
        Category categoryFound = categoryRepository.findById(id).get();
        categoryFound.setName(category.getName());
        categoryFound.setDescription(category.getDescription());
        categoryFound.setImageUrl(category.getImageUrl());
        return categoryRepository.save(categoryFound);
    }
}
