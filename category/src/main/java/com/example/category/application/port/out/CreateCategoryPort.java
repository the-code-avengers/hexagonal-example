package com.example.category.application.port.out;

import com.example.category.domain.Category;

public interface CreateCategoryPort {

    Category create(Category category);

    Category delete(Long id);
}
