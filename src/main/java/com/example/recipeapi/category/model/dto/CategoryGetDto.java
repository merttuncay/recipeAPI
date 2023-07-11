package com.example.recipeapi.category.model.dto;

import com.example.recipeapi.category.model.Category;
import com.example.recipeapi.web.model.BaseViewModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryGetDto extends BaseViewModel {
    private String categoryName;

    public CategoryGetDto(Category category){
        setKey(category.getId());
        setCategoryName(category.getCategoryName());
    }
}
