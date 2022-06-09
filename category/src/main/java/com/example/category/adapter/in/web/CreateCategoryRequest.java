package com.example.category.adapter.in.web;

import javax.validation.constraints.NotBlank;

public class CreateCategoryRequest {

    @NotBlank
    private String name;

    public CreateCategoryRequest() {
    }

    public CreateCategoryRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
