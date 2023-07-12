package com.example.recipeapi.recipe.model.dto;


import com.example.recipeapi.category.model.Category;
import com.example.recipeapi.category.model.dto.CategoryInsertDto;
import com.example.recipeapi.ingredient.model.RecipeIngredient;
import com.example.recipeapi.ingredient.model.dto.RecipeIngredientInsertDto;
import com.example.recipeapi.recipe.model.Recipe;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeInsertDto {
    private String recipeName;
    private String directions;
    private List<RecipeIngredientInsertDto> recipeIngredients = new ArrayList<>();
    private List<CategoryInsertDto> categories = new ArrayList<>();
    private Integer yieldNumber;

    public Recipe toRecipe(){
        Recipe recipe = new Recipe();
        recipe.setRecipeName(recipeName);
        recipe.setDirections(directions);
        recipe.setRecipeIngredients(recipeIngredients.stream().map(recipeIngredient -> new RecipeIngredient(recipe,recipeIngredient.toRecipeIngredient().getIngredient(), recipeIngredient.getUnit(), recipeIngredient.getQuantity(), recipeIngredient.getDescription())).toList());
        recipe.setCategories(categories.stream().map(categoryInsertDto -> new Category(recipe, categoryInsertDto.getCategoryName())).toList());
        recipe.setYieldNumber(yieldNumber);
        return recipe;
    }
}
