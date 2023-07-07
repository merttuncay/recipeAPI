package com.example.recipeapi.category.model.dto;

import com.example.recipeapi.category.model.Category;
import com.example.recipeapi.recipe.model.Recipe;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryInsertDto {
    private Long key;
    private Recipe recipeId;
    private String categoryName;

    public Category toCategory(){
        Category category = new Category();
        category.setId(key);
        category.setRecipeId(recipeId);
        category.setCategoryName(categoryName);
        return category;
    }
}
