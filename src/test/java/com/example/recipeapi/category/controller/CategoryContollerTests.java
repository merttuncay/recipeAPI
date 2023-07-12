package com.example.recipeapi.category.controller;

import com.example.recipeapi.category.model.Category;
import com.example.recipeapi.category.model.dto.CategoryGetDto;
import com.example.recipeapi.category.service.CategoryService;
import com.example.recipeapi.recipe.model.Recipe;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CategoryController.class)
public class CategoryContollerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryService categoryService;

    private static Category category;

    @BeforeAll
    public static void setUp(){
        Recipe recipe = new Recipe();
        category = new Category();
        category.setId(-1L);
        category.setCategoryName("Main dish");
        category.setRecipe(recipe);
    }

    @Test
    void givenCategory_whenGetCategories_thenStatus200(){
        CategoryGetDto categoryGetDto = new CategoryGetDto(category);
        List<CategoryGetDto> categoryGetDtoList = List.of(categoryGetDto);
        given(categoryService.findAllCategories()).willReturn(categoryGetDtoList);
    }
    @Test
    void notGivenCategory_whenGetCategory_thenStatus404() throws Exception {
        mockMvc.perform(get("/category/*123").contentType(MediaType.APPLICATION_JSON)).andExpect(status().is4xxClientError());
    }

}
