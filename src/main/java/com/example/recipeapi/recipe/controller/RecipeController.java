package com.example.recipeapi.recipe.controller;


import com.example.recipeapi.recipe.model.dto.RecipeGetDto;
import com.example.recipeapi.recipe.model.dto.RecipeInsertDto;
import com.example.recipeapi.recipe.model.dto.RecipeSearchDto;
import com.example.recipeapi.recipe.service.RecipeService;
import com.example.recipeapi.web.model.BasePageableResponse;
import com.example.recipeapi.web.model.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService service;

    @GetMapping
    public ResponseEntity<BasePageableResponse> search(@ModelAttribute RecipeSearchDto searchDto) {
        final List<RecipeGetDto> recipeGetDtoList = service.search(searchDto);
        return ResponseEntity.ok(BasePageableResponse.successResponse(recipeGetDtoList, 1, recipeGetDtoList.size()));
    }

    @PostMapping
    public ResponseEntity<BaseResponse> add(@ModelAttribute RecipeInsertDto insertDto){
        service.save(insertDto);
        return ResponseEntity.ok(BaseResponse.successResponse(null,"Recipe insertion is successful."));
    }

}
