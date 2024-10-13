package org.project.ecommerce.service;

import org.project.ecommerce.dtos.requests.CategoryCreateRequest;
import org.project.ecommerce.entities.Category;
import org.project.ecommerce.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService{

    @Autowired private CategoryRepository categoryRepository;

    @Override
    public Category save(CategoryCreateRequest request) {
        Category category = new Category();
        category.setCategoryName(request.getName());
        category.setStatus(true);
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(String id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Override
    public Category getCategoryByName(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName);
    }

    @Override
    public List<Category> getAllByName(String name) {
        return categoryRepository.findAllByCategoryName(name);
    }

    @Override
    public Category update(String id, CategoryCreateRequest request) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        category.setCategoryName(request.getName());
        category.setStatus(true);
        return categoryRepository.save(category);
    }

    @Override
    public boolean changeStatus(String id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        category.setStatus(false);
        categoryRepository.save(category);
        return true;
    }
}
