package com.example.recipeapi.ingredient.model.dto;

import com.example.recipeapi.ingredient.model.Ingredient;
import com.example.recipeapi.ingredient.model.RecipeIngredient;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class IngredientInsertDto {
    private Long key;
    private String ingredientName;
    private Set<RecipeIngredient> recipeIngredients;

    public Ingredient toIngredient(){
        Ingredient ingredient = new Ingredient();
        ingredient.setId(key);
        ingredient.setIngredientName(ingredientName);
        ingredient.setRecipeIngredients(recipeIngredients);
        return ingredient;
    }
}
