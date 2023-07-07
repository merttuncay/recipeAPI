package com.example.recipeapi.web.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class PageFilterViewModel extends BaseViewModel {
    private Integer pageNumber;
    private Integer pageSize;

}
