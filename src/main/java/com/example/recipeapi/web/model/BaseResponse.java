package com.example.recipeapi.web.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BaseResponse {

    private final Object data;
    private final boolean success;
    private final String message;

    public static BaseResponse successResponse(Object data, String message){ return new BaseResponse(data, true, message);}

    public static BaseResponse failureResponse(String message) { return new BaseResponse(null,false,message);}

}
