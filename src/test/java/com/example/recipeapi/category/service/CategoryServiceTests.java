package com.example.recipeapi.category.service;

import com.example.recipeapi.category.model.Category;
import com.example.recipeapi.category.model.dto.CategoryGetDto;
import com.example.recipeapi.category.model.dto.CategoryInsertDto;
import com.example.recipeapi.category.repository.CategoryRepository;
import com.example.recipeapi.category.service.impl.CategoryServiceImpl;
import com.example.recipeapi.recipe.model.Recipe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTests {
    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Mock
    private CategoryRepository categoryRepository;

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
    void givenCategory_whenSaveCategory_thenReturnCategory(){
        given(categoryRepository.save(category)).willReturn(category);
        CategoryInsertDto categoryInsertDto = new CategoryInsertDto(category.getCategoryName());
        Category category1 = categoryService.save(categoryInsertDto);
        Assertions.assertNotNull(category1);
    }

    @Test
    void whenGetCategories_returnCategoryGetDtoList(){
        given(categoryRepository.findAll()).willReturn(List.of(category));
        CategoryGetDto categoryGetDto = new CategoryGetDto(category);
        List<CategoryGetDto> categoryList = categoryService.findAllCategories();
        Assertions.assertEquals(1, categoryList.size());
        CategoryGetDto categoryGetDto1 = categoryList.get(0);
        Assertions.assertEquals(categoryGetDto.getCategoryName(),categoryGetDto1.getCategoryName());
        Assertions.assertEquals(categoryGetDto.getKey(), categoryGetDto1.getKey());
    }

}
