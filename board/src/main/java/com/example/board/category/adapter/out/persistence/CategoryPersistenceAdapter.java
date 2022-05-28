package com.example.board.category.adapter.out.persistence;

import com.example.board.category.application.port.out.LoadCategoryPort;
import org.springframework.stereotype.Component;

@Component
public class CategoryPersistenceAdapter implements LoadCategoryPort {

    private CategoryRepository categoryRepository;

    public CategoryPersistenceAdapter(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryEntity createCategory(CategoryEntity categoryEntity) {
        return categoryRepository.save(categoryEntity);
    }
}
