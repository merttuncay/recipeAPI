package com.example.recipeapi.recipe.model.dto;

import com.example.recipeapi.category.model.dto.CategoryGetDto;
import com.example.recipeapi.ingredient.model.dto.RecipeIngredientGetDto;
import com.example.recipeapi.recipe.model.Recipe;
import com.example.recipeapi.web.model.BaseViewModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class RecipeGetDto extends BaseViewModel {
    private String recipeName;
    private Set<RecipeIngredientGetDto> recipeIngredients;
    private Set<CategoryGetDto> categories;

    public RecipeGetDto(Recipe recipe){
        setKey(recipe.getId());
        setRecipeName(recipe.getRecipeName());
        setRecipeIngredients(recipe.getRecipeIngredients().stream().map(RecipeIngredientGetDto::new).collect(Collectors.toSet()));
        setCategories(recipe.getCategories().stream().map(CategoryGetDto::new).collect(Collectors.toSet()));
    }
}
