package com.example.recipeapi.ingredient.model.dto;

import com.example.recipeapi.ingredient.model.Ingredient;
import com.example.recipeapi.web.model.BaseViewModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class IngredientGetDto extends BaseViewModel {
    private String ingredientName;
    private Set<RecipeIngredientGetDto> recipeIngredients;

    public IngredientGetDto(Ingredient ingredient){
        setKey(ingredient.getId());
        setIngredientName(ingredient.getIngredientName());
        setRecipeIngredients(ingredient.getRecipeIngredients().stream().map(RecipeIngredientGetDto::new).collect(Collectors.toSet()));
    }
}
