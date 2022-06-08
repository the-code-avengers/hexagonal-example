package com.example.category.application;

import com.example.category.adapter.in.web.CategoryResponse;
import com.example.category.application.port.in.CreateCategoryUseCase;
import com.example.category.application.port.out.CreateCategoryPort;
import com.example.category.domain.Category;
import org.springframework.stereotype.Service;

@Service
public class CreateCategoryService implements CreateCategoryUseCase {

    private final CreateCategoryPort createCategoryPort;

    public CreateCategoryService(CreateCategoryPort createCategoryPort) {
        this.createCategoryPort = createCategoryPort;
    }

    @Override
    public CategoryResponse create(String name) {
        Category category = new Category(name);
        Category newCategory = createCategoryPort.createCategory(category);

        return new CategoryResponse(newCategory.getId(), newCategory.getName());
    }
}
