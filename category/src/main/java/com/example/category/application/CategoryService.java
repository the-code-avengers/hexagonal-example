package com.example.category.application;

import com.example.category.adapter.in.web.CategoryResponse;
import com.example.category.application.port.in.CreateCategoryUseCase;
import com.example.category.application.port.out.CreateCategoryPort;
import com.example.category.application.port.out.FindCategoryPort;
import com.example.category.domain.Category;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements CreateCategoryUseCase {

    private final CreateCategoryPort createCategoryPort;
    private final FindCategoryPort findCategoryPort;

    public CategoryService(CreateCategoryPort createCategoryPort, FindCategoryPort findCategoryPort) {
        this.createCategoryPort = createCategoryPort;
        this.findCategoryPort = findCategoryPort;
    }

    @Override
    public CategoryResponse create(String name) {
        if (this.findCategoryPort.existByName(name)) {
            throw new RuntimeException("Category name already exists: \"" + name + "\"");
        }

        Category category = new Category(name);
        Category newCategory = createCategoryPort.create(category);

        return CategoryResponse.of(newCategory);
    }

    @Override
    public CategoryResponse delete(Long id) {
        Category category = this.createCategoryPort.delete(id);

        return CategoryResponse.of(category);
    }
}
