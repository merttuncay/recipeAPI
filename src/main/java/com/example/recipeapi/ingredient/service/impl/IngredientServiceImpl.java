package com.example.recipeapi.ingredient.service.impl;

import com.example.recipeapi.ingredient.model.dto.IngredientInsertDto;
import com.example.recipeapi.ingredient.repository.IngredientRepository;
import com.example.recipeapi.ingredient.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository repository;

    @Override
    public void save(IngredientInsertDto insertDto){
        repository.saveAndFlush(insertDto.toIngredient());
    }
}
