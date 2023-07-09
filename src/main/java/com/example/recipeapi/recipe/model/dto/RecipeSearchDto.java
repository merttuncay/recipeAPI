package com.example.recipeapi.recipe.model.dto;

import com.example.recipeapi.web.model.PageFilterViewModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecipeSearchDto extends PageFilterViewModel {
    private String recipeName;
    private String categoryName;
}
