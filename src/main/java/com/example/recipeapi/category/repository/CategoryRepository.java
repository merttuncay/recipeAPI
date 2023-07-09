package com.example.recipeapi.category.repository;

import com.example.recipeapi.category.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    List<Category> findCategoriesByRecipeId(long recipeId);
}
