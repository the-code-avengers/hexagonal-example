package com.example.board.category.application;

import com.example.board.category.adapter.in.web.CategoryResponse;
import com.example.board.category.adapter.out.persistence.CategoryEntity;
import com.example.board.category.application.port.in.CategoryUseCase;
import com.example.board.category.application.port.out.LoadCategoryPort;
import com.example.board.category.domain.Category;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryService implements CategoryUseCase {

    private LoadCategoryPort loadCategoryPort;

    public CategoryService(LoadCategoryPort loadCategoryPort) {
        this.loadCategoryPort = loadCategoryPort;
    }

    @Override
    public CategoryResponse createUseCase(String categoryName) {
        Category category = new Category(categoryName);
        final CategoryEntity categoryEntity = this.toCategoryEntity(category);

        final CategoryEntity savedCategory = loadCategoryPort.createCategory(categoryEntity);
        return this.toCategoryResponse(savedCategory);
    }

    private CategoryResponse toCategoryResponse(CategoryEntity categoryEntity) {
        return new CategoryResponse(categoryEntity.getId(),
                                    categoryEntity.getName());
    }

    private CategoryEntity toCategoryEntity(Category category) {
        return new CategoryEntity(category.getName());
    }
}
