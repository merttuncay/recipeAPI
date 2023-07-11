package com.example.recipeapi.recipe.service.impl;

import com.example.recipeapi.recipe.model.Recipe;
import com.example.recipeapi.recipe.model.dto.RecipeGetDto;
import com.example.recipeapi.recipe.model.dto.RecipeInsertDto;
import com.example.recipeapi.recipe.model.dto.RecipeSearchDto;
import com.example.recipeapi.recipe.repository.RecipeRepository;
import com.example.recipeapi.recipe.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository repository;


    @Override
    public List<RecipeGetDto> search(RecipeSearchDto searchDto){
        return repository.search(searchDto.getRecipeName(), searchDto.getCategoryName()).stream().map(RecipeGetDto::new).toList();
    }
    @Override
    public Recipe save(RecipeInsertDto insertDto){
        return repository.save(insertDto.toRecipe());
    }
}
