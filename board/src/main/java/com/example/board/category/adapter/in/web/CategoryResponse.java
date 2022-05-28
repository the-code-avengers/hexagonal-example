package com.example.board.category.adapter.in.web;

import lombok.Value;

@Value
public class CategoryResponse {
    private Long id;
    private String name;

    public CategoryResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
