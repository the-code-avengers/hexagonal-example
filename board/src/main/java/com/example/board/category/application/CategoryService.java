package com.example.board.category.application;

import com.example.board.category.application.port.in.CategoryUseCase;
import com.example.board.category.domain.Category;

public class CategoryService implements CategoryUseCase {

    @Override
    public void useCase() {
        Category category = new Category();
        category.logic();

        // db access
    }
}
