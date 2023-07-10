package com.example.recipeapi.ingredient.model.dto;

import com.example.recipeapi.ingredient.model.Ingredient;
import com.example.recipeapi.web.model.BaseViewModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class IngredientGetDto extends BaseViewModel {
    private String ingredientName;

    public IngredientGetDto(Ingredient ingredient){
        setKey(ingredient.getId());
        setIngredientName(ingredient.getIngredientName());
    }
}
