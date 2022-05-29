package com.example.board.category.application.port.out;

import com.example.board.category.adapter.out.persistence.CategoryEntity;

import java.util.Optional;

public interface LoadCategoryPort {
    CategoryEntity createCategory(CategoryEntity category);

    CategoryEntity loadCategory(Long categoryId);

    Optional<CategoryEntity> loadCategory(String name);

    void deleteCategory(CategoryEntity loadCategory);
}
