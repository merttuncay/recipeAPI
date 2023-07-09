package com.example.recipeapi.recipe.model.dto;

import com.example.recipeapi.category.model.Category;
import com.example.recipeapi.ingredient.model.RecipeIngredient;
import com.example.recipeapi.recipe.model.Recipe;
import com.example.recipeapi.web.model.BaseViewModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RecipeGetDto extends BaseViewModel {
    private String recipeName;
    private Set<RecipeIngredient> recipeIngredients;
    private Set<Category> categories;

    public RecipeGetDto(Recipe recipe){
        setKey(recipe.getId());
        setRecipeName(recipe.getRecipeName());
        setRecipeIngredients(recipe.getRecipeIngredients());
        setCategories(recipe.getCategories());
    }
}
