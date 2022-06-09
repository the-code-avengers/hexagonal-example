package com.example.category.application.port.in;

import com.example.category.adapter.in.web.CategoryResponse;

public interface CreateCategoryUseCase {

    CategoryResponse create(String name);

    CategoryResponse delete(Long id);
}
