package com.example.recipeapi.ingredient.model.dto;

import com.example.recipeapi.ingredient.model.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IngredientInsertDto {
    private String ingredientName;

    public Ingredient toIngredient(){
        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientName(ingredientName);
        return ingredient;
    }
}
