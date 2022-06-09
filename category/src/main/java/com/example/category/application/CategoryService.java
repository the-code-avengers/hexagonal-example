package com.example.category.application;

import com.example.category.adapter.in.web.CategoryResponse;
import com.example.category.application.port.in.CreateCategoryUseCase;
import com.example.category.application.port.out.CategoryPort;
import com.example.category.domain.Category;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements CreateCategoryUseCase {

    private final CategoryPort categoryPort;

    public CategoryService(CategoryPort categoryPort) {
        this.categoryPort = categoryPort;
    }

    @Override
    public CategoryResponse create(String name) {
        if (this.categoryPort.existByName(name)) {
            throw new RuntimeException("Category name already exists: \"" + name + "\"");
        }

        Category category = new Category(name);
        Category newCategory = categoryPort.create(category);

        return CategoryResponse.of(newCategory);
    }

    @Override
    public CategoryResponse delete(Long id) {
        Category category = this.categoryPort.delete(id);

        return CategoryResponse.of(category);
    }
}
