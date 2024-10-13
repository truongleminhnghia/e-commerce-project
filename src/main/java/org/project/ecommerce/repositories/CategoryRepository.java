package org.project.ecommerce.repositories;

import org.project.ecommerce.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
    Category findByCategoryName(String name);
    List<Category> findAllByOrderByCategoryNameAsc();
    List<Category> findAllByCategoryName(String name);
}
