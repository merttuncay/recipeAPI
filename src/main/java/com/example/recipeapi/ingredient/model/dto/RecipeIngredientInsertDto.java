package com.example.recipeapi.ingredient.model.dto;


import com.example.recipeapi.ingredient.model.RecipeIngredient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeIngredientInsertDto {
    private String unit;
    private String quantity;
    private String description;
    private IngredientInsertDto ingredientInsertDto;


    public RecipeIngredient toRecipeIngredient(){
        RecipeIngredient recipeIngredient = new RecipeIngredient();
        recipeIngredient.setUnit(unit);
        recipeIngredient.setQuantity(quantity);
        recipeIngredient.setDescription(description);
        recipeIngredient.setIngredient(ingredientInsertDto.toIngredient());
        return recipeIngredient;
    }
}
