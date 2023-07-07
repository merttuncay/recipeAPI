package com.example.recipeapi.ingredient.model.dto;


import com.example.recipeapi.ingredient.model.Ingredient;
import com.example.recipeapi.ingredient.model.RecipeIngredient;
import com.example.recipeapi.recipe.model.Recipe;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class RecipeIngredientInsertDto {
    private Long key;
    private Recipe recipe;
    private Ingredient ingredient;
    private String unit;
    private BigDecimal quantity;
    private String description;


    public RecipeIngredient toRecipeIngredient(){
        RecipeIngredient recipeIngredient = new RecipeIngredient();
        recipeIngredient.setId(key);
        recipeIngredient.setRecipeId(recipe);
        recipeIngredient.setIngredientId(ingredient);
        recipeIngredient.setUnit(unit);
        recipeIngredient.setQuantity(quantity);
        recipeIngredient.setDescription(description);
        return recipeIngredient;
    }
}
