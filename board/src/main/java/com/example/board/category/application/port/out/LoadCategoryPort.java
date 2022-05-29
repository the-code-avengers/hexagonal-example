package com.example.board.category.application.port.out;

import com.example.board.category.adapter.out.persistence.CategoryEntity;

public interface LoadCategoryPort {
    CategoryEntity createCategory(CategoryEntity category);

    CategoryEntity loadCategory(Long categoryId);

    void deleteCategory(CategoryEntity loadCategory);
}
