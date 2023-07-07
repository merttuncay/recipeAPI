package com.example.recipeapi.ingredient.service.impl;

import com.example.recipeapi.ingredient.model.dto.RecipeIngredientInsertDto;
import com.example.recipeapi.ingredient.repository.RecipeIngredientRepository;
import com.example.recipeapi.ingredient.service.RecipeIngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
@RequiredArgsConstructor
public class RecipeIngredientServiceImpl implements RecipeIngredientService {

    private final RecipeIngredientRepository repository;

    @Override
    public void save(RecipeIngredientInsertDto insertDto){
        repository.saveAndFlush(insertDto.toRecipeIngredient());
    }
}
