package com.example.recipeapi.category.model.dto;

import com.example.recipeapi.category.model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryInsertDto {
    private String categoryName;

    public Category toCategory(){
        Category category = new Category();
        category.setCategoryName(categoryName);
        return category;
    }
}
