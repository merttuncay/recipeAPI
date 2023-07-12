package com.example.recipeapi.category.service;

import com.example.recipeapi.category.model.Category;
import com.example.recipeapi.category.model.dto.CategoryGetDto;
import com.example.recipeapi.category.model.dto.CategoryInsertDto;

import java.util.List;

public interface CategoryService {
    List<CategoryGetDto> search(long recipeId);

    List<CategoryGetDto> findAllCategories();

    Category save(CategoryInsertDto insertDto);
}
