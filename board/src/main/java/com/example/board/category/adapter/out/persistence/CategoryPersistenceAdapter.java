package com.example.board.category.adapter.out.persistence;

import com.example.board.category.application.port.out.LoadCategoryPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CategoryPersistenceAdapter implements LoadCategoryPort {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryEntity createCategory(CategoryEntity categoryEntity) {
        return categoryRepository.save(categoryEntity);
    }
}
