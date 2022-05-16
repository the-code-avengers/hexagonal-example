package com.example.board.category.application;

import com.example.board.category.application.port.in.CategoryUseCase;
import com.example.board.category.application.port.out.LoadCategoryPort;
import com.example.board.category.domain.Category;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CategoryService implements CategoryUseCase {

    private final LoadCategoryPort loadCategoryPort;

    @Override
    public void useCase() {
        Category category = new Category();
        category.logic();

        // db access
        loadCategoryPort.persistenceLogic(category);

        return;
    }
}
