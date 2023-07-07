package com.example.recipeapi.recipe.model.dto;


import com.example.recipeapi.recipe.model.Recipe;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RecipeInsertDto {
    private long key;
    private String recipeName;

    public Recipe toRecipe(){
        Recipe recipe = new Recipe();
        recipe.setId(key);
        recipe.setRecipeName(recipeName);
        return recipe;
    }
}
