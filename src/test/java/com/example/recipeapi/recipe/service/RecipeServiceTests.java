package com.example.recipeapi.recipe.service;

import com.example.recipeapi.category.model.Category;
import com.example.recipeapi.ingredient.model.Ingredient;
import com.example.recipeapi.ingredient.model.RecipeIngredient;
import com.example.recipeapi.recipe.model.Recipe;
import com.example.recipeapi.recipe.model.dto.RecipeGetDto;
import com.example.recipeapi.recipe.model.dto.RecipeInsertDto;
import com.example.recipeapi.recipe.model.dto.RecipeSearchDto;
import com.example.recipeapi.recipe.repository.RecipeRepository;
import com.example.recipeapi.recipe.service.impl.RecipeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class RecipeServiceTests {

    @InjectMocks
    private RecipeServiceImpl recipeService;

    @Mock
    private RecipeRepository recipeRepository;

    private static Recipe recipe;

    @BeforeAll
    public static void setUp(){
        recipe = new Recipe();
        Category category = new Category();
        category.setId(-1L);
        category.setCategoryName("Main dish");
        category.setRecipe(recipe);
        recipe.setCategories(List.of(category));
        RecipeIngredient recipeIngredient = new RecipeIngredient();
        recipeIngredient.setId(-1L);
        Ingredient ingredient = new Ingredient();
        ingredient.setId(1L);
        ingredient.setIngredientName("Ground chuck or lean ground");
        recipeIngredient.setIngredient(ingredient);
        recipeIngredient.setUnit("pound");
        recipeIngredient.setQuantity("1");
        recipeIngredient.setDescription("beef");
        recipe.setRecipeIngredients(List.of(recipeIngredient));
    }

    @Test
    void givenRecipe_whenSaveRecipe_thenReturnRecipe() {
        given(recipeRepository.save(recipe)).willReturn(recipe);
        RecipeInsertDto recipeInsertDto = new RecipeInsertDto(recipe.getRecipeName(), "", Collections.emptyList(), Collections.emptyList(),1);
        Recipe recipe1 = recipeService.save(recipeInsertDto);
        Assertions.assertNotNull(recipe1);
    }

    @Test
    void givenRecipeSearchDto_whenSearch_thenReturnRecipeGetDtoList(){
        RecipeSearchDto recipeSearchDto = new RecipeSearchDto();
        recipeSearchDto.setRecipeName("Test Recipe Name");
        given(recipeRepository.search(recipeSearchDto.getRecipeName(), recipeSearchDto.getCategoryName())).willReturn(List.of(recipe));
        RecipeGetDto recipeGetDto = new RecipeGetDto(recipe);
        List<RecipeGetDto> recipeGetDtoList = recipeService.search(recipeSearchDto);
        Assertions.assertEquals(1,recipeGetDtoList.size());
        RecipeGetDto recipeGetDto1 = recipeGetDtoList.get(0);
        Assertions.assertEquals(recipeGetDto.getRecipeName(), recipeGetDto1.getRecipeName());
        Assertions.assertEquals(recipeGetDto.getKey(), recipeGetDto1.getKey());
        Assertions.assertEquals(recipeGetDto.getCategories().size(), recipeGetDto1.getCategories().size());
        Assertions.assertEquals(recipeGetDto.getRecipeIngredients().size(), recipeGetDto1.getRecipeIngredients().size());
    }
}
