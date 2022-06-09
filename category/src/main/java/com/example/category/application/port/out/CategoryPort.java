package com.example.category.application.port.out;

import com.example.category.domain.Category;

public interface CategoryPort {

    Category create(Category category);

    Category delete(Long id);

    Boolean existByName(String name);
}
