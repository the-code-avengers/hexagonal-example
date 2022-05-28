package com.example.board.category.application.port.in;

import com.example.board.category.adapter.in.web.CategoryResponse;

public interface CategoryUseCase {
    CategoryResponse createUseCase(String categoryName);
}
