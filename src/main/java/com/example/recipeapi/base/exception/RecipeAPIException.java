package com.example.recipeapi.base.exception;


import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RecipeAPIException extends Exception{
    public RecipeAPIException(String message, Throwable cause) {super(message, cause);}
    public RecipeAPIException(String message){super(message);}
}
