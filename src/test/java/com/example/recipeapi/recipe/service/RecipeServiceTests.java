package com.example.recipeapi.recipe.service;

import com.example.recipeapi.category.model.Category;
import com.example.recipeapi.ingredient.model.Ingredient;
import com.example.recipeapi.ingredient.model.RecipeIngredient;
import com.example.recipeapi.recipe.model.Recipe;
import com.example.recipeapi.recipe.model.dto.RecipeInsertDto;
import com.example.recipeapi.recipe.repository.RecipeRepository;
import com.example.recipeapi.recipe.service.impl.RecipeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
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
        recipeIngredient.setQuantity(BigDecimal.ONE);
        recipeIngredient.setDescription("beef");
        recipe.setRecipeIngredients(List.of(recipeIngredient));
    }

    @Test
    void givenRecipe_whenSaveRecipe_thenReturnRecipe() {
        given(recipeRepository.save(recipe)).willReturn(recipe);
        RecipeInsertDto recipeInsertDto = new RecipeInsertDto(recipe.getId(), recipe.getRecipeName(), recipe.getRecipeIngredients(), recipe.getCategories());
        Recipe recipe1 = recipeService.save(recipeInsertDto);
        Assertions.assertNotNull(recipe1);
    }
}
