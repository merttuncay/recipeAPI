package com.example.recipeapi.recipe.model.dto;

import com.example.recipeapi.category.model.dto.CategoryGetDto;
import com.example.recipeapi.ingredient.model.dto.RecipeIngredientGetDto;
import com.example.recipeapi.recipe.model.Recipe;
import com.example.recipeapi.web.model.BaseViewModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RecipeGetDto extends BaseViewModel {
    private String recipeName;
    private List<RecipeIngredientGetDto> recipeIngredients;
    private List<CategoryGetDto> categories;
    private String directions;
    private Integer yieldNumber;

    public RecipeGetDto(Recipe recipe){
        setKey(recipe.getId());
        setRecipeName(recipe.getRecipeName());
        setRecipeIngredients(recipe.getRecipeIngredients().stream().map(RecipeIngredientGetDto::new).toList());
        setCategories(recipe.getCategories().stream().map(CategoryGetDto::new).toList());
        setDirections(recipe.getDirections());
        setYieldNumber(recipe.getYieldNumber());
    }
}
