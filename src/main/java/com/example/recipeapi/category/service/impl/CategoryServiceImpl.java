package com.example.recipeapi.category.service.impl;

import com.example.recipeapi.category.model.dto.CategoryGetDto;
import com.example.recipeapi.category.model.dto.CategoryInsertDto;
import com.example.recipeapi.category.repository.CategoryRepository;
import com.example.recipeapi.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    @Override
    public List<CategoryGetDto> search(long recipeId) {
        return repository.findCategoriesByRecipeId(recipeId).stream().map(CategoryGetDto::new).toList();
    }

    @Override
    public List<CategoryGetDto> findAllCategories(){
        return repository.findAll().stream().map(CategoryGetDto::new).toList();
    }
    @Override
    public void save(CategoryInsertDto insertDto){
        repository.saveAndFlush(insertDto.toCategory());
    }
}
