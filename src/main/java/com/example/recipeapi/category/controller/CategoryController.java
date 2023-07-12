package com.example.recipeapi.category.controller;


import com.example.recipeapi.category.model.dto.CategoryGetDto;
import com.example.recipeapi.category.service.CategoryService;
import com.example.recipeapi.web.model.BasePageableResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService service;

    @GetMapping
    public ResponseEntity<BasePageableResponse> findAll() {
        final List<CategoryGetDto> categoryGetDtoList = service.findAllCategories();
        return ResponseEntity.ok(BasePageableResponse.successResponse(categoryGetDtoList, 1, categoryGetDtoList.size()));
    }
    @GetMapping("/{recipeId}")
    public ResponseEntity<BasePageableResponse> search(@PathVariable("recipeId") long recipeId) {
        final List<CategoryGetDto> categoryGetDtoList = service.search(recipeId);
        return ResponseEntity.ok(BasePageableResponse.successResponse(categoryGetDtoList, 1, categoryGetDtoList.size()));
    }

}
