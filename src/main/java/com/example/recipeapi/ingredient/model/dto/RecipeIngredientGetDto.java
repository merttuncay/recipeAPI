package com.example.recipeapi.ingredient.model.dto;

import com.example.recipeapi.ingredient.model.RecipeIngredient;
import com.example.recipeapi.recipe.model.dto.RecipeGetDto;
import com.example.recipeapi.web.model.BaseViewModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class RecipeIngredientGetDto extends BaseViewModel {
    private String unit;
    private BigDecimal quantity;
    private String description;

    public RecipeIngredientGetDto(RecipeIngredient recipeIngredient){
        setKey(recipeIngredient.getId());
        setUnit(recipeIngredient.getUnit());
        setQuantity(recipeIngredient.getQuantity());
        setDescription(recipeIngredient.getDescription());
    }

}
