package com.example.recipeapi.ingredient.service;

import com.example.recipeapi.ingredient.model.dto.IngredientInsertDto;

public interface IngredientService {
    void save(IngredientInsertDto insertDto);
}
