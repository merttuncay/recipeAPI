package com.example.recipeapi.recipe.service;

import com.example.recipeapi.recipe.model.dto.RecipeInsertDto;

public interface RecipeParserService {
    RecipeInsertDto saveRecipe(byte[] data) throws Exception;
}
