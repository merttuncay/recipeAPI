package com.example.recipeapi.web.model;


import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;


@Getter
@Setter
public class BasePageableResponse extends BaseResponse{
    private int totalPages;
    private long totalElements;

    public BasePageableResponse(Object data, boolean success, String message, int totalPages, long totalElements) {
        super(data, success, message);
        this.totalPages = totalPages;
        this.totalElements = totalElements;
    }

    public static BasePageableResponse successResponse(Object data, int totalPages, long totalElements){
        return new BasePageableResponse(data,true, StringUtils.EMPTY, totalPages, totalElements);
    }
}
