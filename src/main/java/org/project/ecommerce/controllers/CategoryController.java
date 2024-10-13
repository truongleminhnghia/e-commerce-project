package org.project.ecommerce.controllers;

import org.project.ecommerce.dtos.requests.CategoryCreateRequest;
import org.project.ecommerce.entities.Category;
import org.project.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/e-commerce/api/v1/categories")
@CrossOrigin("/**")
public class CategoryController {
    @Autowired private CategoryService categoryService;

    @PostMapping("/create")
    ResponseEntity<?> create(@RequestBody CategoryCreateRequest request) {
        try {
            Category category = categoryService.save(request);
            return ResponseEntity.ok().body(category);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping()
    ResponseEntity<?> getAll() {
        try {
            List<Category> categories = categoryService.getAllCategories();
            if(categories.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok().body(categories);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{categori_id}")
    ResponseEntity<?> getById(@PathVariable("categori_id") String id) {
        try {
            Category category = categoryService.getCategoryById(id);
            if(category == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(category);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("category/{category_name}")
    ResponseEntity<?> getByName(@PathVariable("category_name") String name) {
        try {
            Category category = categoryService.getCategoryByName(name);
            if(category == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(category);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/update/{category_id}")
    ResponseEntity<?> updateCategory(@PathVariable("category_id") String id,@RequestBody CategoryCreateRequest request) {
        try {
            Category category = categoryService.update(id, request);
            return ResponseEntity.ok().body(category);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{category_id}")
    ResponseEntity<?> changeStatus(@PathVariable("category_id") String id) {
        try {
            boolean result = categoryService.changeStatus(id);
            if(result) {
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
