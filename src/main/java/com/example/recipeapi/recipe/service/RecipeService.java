package com.example.recipeapi.recipe.service;

import com.example.recipeapi.recipe.model.dto.RecipeGetDto;
import com.example.recipeapi.recipe.model.dto.RecipeInsertDto;
import com.example.recipeapi.recipe.model.dto.RecipeSearchDto;

import java.util.List;

public interface RecipeService {
    List<RecipeGetDto> search(RecipeSearchDto searchDto);

    void save(RecipeInsertDto insertDto);
}
