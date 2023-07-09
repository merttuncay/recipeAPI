package com.example.recipeapi.category.model.dto;

import com.example.recipeapi.category.model.Category;
import com.example.recipeapi.recipe.model.Recipe;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryInsertDto {
    private Long key;
    private Recipe recipe;
    private String categoryName;

    public Category toCategory(){
        Category category = new Category();
        category.setId(key);
        category.setRecipe(recipe);
        category.setCategoryName(categoryName);
        return category;
    }
}
