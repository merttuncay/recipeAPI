package com.example.recipeapi.category.service;

import com.example.recipeapi.category.model.Category;
import com.example.recipeapi.category.model.dto.CategoryInsertDto;

import java.util.List;

public interface CategoryService {
    List<Category> search(long recipeId);

    void save(CategoryInsertDto insertDto);
}
