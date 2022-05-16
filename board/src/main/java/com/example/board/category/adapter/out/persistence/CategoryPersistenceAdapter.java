package com.example.board.category.adapter.out.persistence;

import com.example.board.category.application.port.out.LoadCategoryPort;
import com.example.board.category.domain.Category;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CategoryPersistenceAdapter implements LoadCategoryPort {

    private final CategoryRepository categoryRepository;

    public Category persistenceLogic(Category category) {
        final CategoryEntity categoryEntity = this.toCategoryEntity(category);
        return this.toCategoryDomain(categoryRepository.save(categoryEntity));
    }

    private Category toCategoryDomain(CategoryEntity categoryEntity) {
        return new Category();
    }

    private CategoryEntity toCategoryEntity(Category category) {
        return new CategoryEntity();
    }
}
