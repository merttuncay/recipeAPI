package com.example.recipeapi.recipe.service;

import com.example.recipeapi.recipe.model.dto.RecipeInsertDto;

public interface RecipeService {
    void save(RecipeInsertDto insertDto);
}
