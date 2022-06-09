package com.example.category.adapter.in.web;

import com.example.category.domain.Category;

public class CategoryResponse {

    private Long id;

    private String name;

    private CategoryResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static CategoryResponse of(Category category) {
        return new CategoryResponse(category.getId(), category.getName());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
