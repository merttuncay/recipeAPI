package com.example.recipeapi.recipe.repository;

import com.example.recipeapi.recipe.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query(value = "Select r from Recipe r join fetch r.categories")
    List<Recipe> search(String recipeName);
}
