package com.example.recipeapi.recipe.repository;

import com.example.recipeapi.recipe.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query(value = """
            SELECT * FROM mendix.recipe r\s
            WHERE LOWER(r.recipe_name) like Lower(CONCAT('%',:recipeName,'%')) and EXISTS (
               SELECT 1 FROM mendix.category c\s
               WHERE r.id  = c.recipe_id and LOWER(c.category_name) like Lower(CONCAT('%',:categoryName,'%'))
            )""", nativeQuery = true)
    List<Recipe> search(String recipeName, String categoryName);
}
