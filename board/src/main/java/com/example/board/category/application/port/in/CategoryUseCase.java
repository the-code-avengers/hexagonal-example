package com.example.board.category.application.port.in;

import com.example.board.category.adapter.in.web.CategoryResponseDTO;

public interface CategoryUseCase {
    CategoryResponseDTO createUseCase(String categoryName);
}
