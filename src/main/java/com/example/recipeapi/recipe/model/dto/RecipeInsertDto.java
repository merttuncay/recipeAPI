package com.example.recipeapi.recipe.model.dto;


import com.example.recipeapi.category.model.Category;
import com.example.recipeapi.ingredient.model.RecipeIngredient;
import com.example.recipeapi.recipe.model.Recipe;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class RecipeInsertDto {
    private long key;
    private String recipeName;
    private List<RecipeIngredient> recipeIngredients;
    private List<Category> categories;

    public Recipe toRecipe(){
        Recipe recipe = new Recipe();
        recipe.setId(key);
        recipe.setRecipeName(recipeName);
        recipe.setRecipeIngredients(recipeIngredients);
        recipe.setCategories(categories);
        return recipe;
    }
}
