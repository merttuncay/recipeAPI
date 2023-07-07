package com.example.recipeapi.ingredient.service;

import com.example.recipeapi.ingredient.model.dto.RecipeIngredientInsertDto;

public interface RecipeIngredientService {
    void save(RecipeIngredientInsertDto insertDto);
}
