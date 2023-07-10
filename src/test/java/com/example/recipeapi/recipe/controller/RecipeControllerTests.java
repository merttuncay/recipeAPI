package com.example.recipeapi.recipe.controller;

import com.example.recipeapi.category.model.Category;
import com.example.recipeapi.category.model.dto.CategoryGetDto;
import com.example.recipeapi.ingredient.model.Ingredient;
import com.example.recipeapi.ingredient.model.RecipeIngredient;
import com.example.recipeapi.ingredient.model.dto.RecipeIngredientGetDto;
import com.example.recipeapi.recipe.model.Recipe;
import com.example.recipeapi.recipe.model.dto.RecipeGetDto;
import com.example.recipeapi.recipe.model.dto.RecipeSearchDto;
import com.example.recipeapi.recipe.service.RecipeParserService;
import com.example.recipeapi.recipe.service.RecipeService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(RecipeController.class)
public class RecipeControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecipeService recipeService;

    @MockBean
    private RecipeParserService recipeParserService;
    private static Recipe recipe;

    @BeforeAll
    public static void setUp(){
        recipe = new Recipe();
        Category category = new Category();
        category.setId(-1);
        category.setCategoryName("Main dish");
        category.setRecipe(recipe);
        recipe.setCategories(List.of(category));
        RecipeIngredient recipeIngredient = new RecipeIngredient();
        recipeIngredient.setId(-1);
        Ingredient ingredient = new Ingredient();
        ingredient.setId(1);
        ingredient.setIngredientName("Ground chuck or lean ground");
        recipeIngredient.setIngredient(ingredient);
        recipeIngredient.setUnit("pound");
        recipeIngredient.setQuantity(BigDecimal.ONE);
        recipeIngredient.setRecipe(recipe);
        recipeIngredient.setDescription("beef");
        recipe.setRecipeIngredients(List.of(recipeIngredient));
    }

    @Test
    void givenRecipe_whenGetRecipe_thenStatus200() throws Exception {
        RecipeGetDto recipeGetDto = new RecipeGetDto();
        recipeGetDto.setKey(recipe.getId());
        recipeGetDto.setRecipeName(recipe.getRecipeName());
        recipeGetDto.setCategories(recipe.getCategories().stream().map(CategoryGetDto::new).toList());
        recipeGetDto.setRecipeIngredients(recipe.getRecipeIngredients().stream().map(RecipeIngredientGetDto::new).toList());

        List<RecipeGetDto> recipeList = List.of(recipeGetDto);

        RecipeSearchDto recipeSearchDto = new RecipeSearchDto();

        given(recipeService.search(recipeSearchDto)).willReturn(recipeList);

        mockMvc.perform(get("/recipe", recipeSearchDto).flashAttr("recipeSearchDto", recipeSearchDto).sessionAttr("recipeSearchDto", recipeSearchDto)
                        .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(jsonPath("$.data", hasSize(1)))
                .andExpect(jsonPath("$.data[0].key", is((int)recipe.getId()))).andExpect(jsonPath("$.data[0].recipeName", is(recipe.getRecipeName())));
    }

}
