package com.example.board.category.application.port.out;

import com.example.board.category.adapter.out.persistence.CategoryEntity;

public interface LoadCategoryPort {
    CategoryEntity createCategory(CategoryEntity category);
}
