package com.example.board.category.application.port.out;

import com.example.board.category.domain.Category;

public interface LoadCategoryPort {
    Category persistenceLogic(Category category);
}
