package org.project.ecommerce.service;

import org.project.ecommerce.dtos.requests.CategoryCreateRequest;
import org.project.ecommerce.entities.Category;

import java.util.List;

public interface CategoryService {
    Category save(CategoryCreateRequest request);
    List<Category> getAllCategories();
    Category getCategoryById(String id);
    Category getCategoryByName(String categoryName);
    List<Category> getAllByName(String name);
    Category update(String id, CategoryCreateRequest request);
    boolean changeStatus(String id);
}
