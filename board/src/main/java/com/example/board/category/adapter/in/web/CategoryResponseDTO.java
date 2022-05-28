package com.example.board.category.adapter.in.web;

import lombok.Value;

@Value
public class CategoryResponseDTO {
    private Long id;
    private String name;

    public CategoryResponseDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
