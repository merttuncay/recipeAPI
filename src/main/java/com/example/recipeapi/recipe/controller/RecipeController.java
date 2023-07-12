package com.example.recipeapi.recipe.controller;


import com.example.recipeapi.recipe.model.dto.RecipeGetDto;
import com.example.recipeapi.recipe.model.dto.RecipeInsertDto;
import com.example.recipeapi.recipe.model.dto.RecipeSearchDto;
import com.example.recipeapi.recipe.service.RecipeParserService;
import com.example.recipeapi.recipe.service.RecipeService;
import com.example.recipeapi.web.model.BasePageableResponse;
import com.example.recipeapi.web.model.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService service;
    private final RecipeParserService parserService;
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

    @PostMapping(path = "/recipeFileUpload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BaseResponse> uploadRecipe(@RequestParam("recipeFile")MultipartFile recipeFile) throws Exception {
        if(fileIsNotXml(recipeFile)){
            return ResponseEntity.ok(BaseResponse.failureResponse("File extension must be '.xml' ."));
        }
        final RecipeInsertDto recipe = parserService.saveRecipe(recipeFile.getBytes());
        if(Objects.isNull(recipe)){
            return ResponseEntity.ok(BaseResponse.failureResponse("Read file amount: 0"));
        }
        return ResponseEntity.ok(BaseResponse.successResponse(null, "Recipe is successfully read from the xml file."));
    }
    private boolean fileIsNotXml(MultipartFile file) { return !Objects.requireNonNull(file.getOriginalFilename()).endsWith(".xml");}

}
