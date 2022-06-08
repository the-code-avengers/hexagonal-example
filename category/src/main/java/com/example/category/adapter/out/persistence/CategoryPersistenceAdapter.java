package com.example.category.adapter.out.persistence;

import com.example.category.application.port.out.CreateCategoryPort;
import com.example.category.domain.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryPersistenceAdapter implements CreateCategoryPort {

    private final CategoryRepository categoryRepository;

    public CategoryPersistenceAdapter(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(Category category) {
        CategoryJpaEntity jpaEntity = CategoryMapper.mapToJpaEntity(category);
        CategoryJpaEntity savedJpaEntity = this.categoryRepository.save(jpaEntity);

        return CategoryMapper.mapToDomainEntity(savedJpaEntity);
    }
}
