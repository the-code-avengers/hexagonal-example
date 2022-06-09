package com.example.category.adapter.out.persistence;

import com.example.category.application.port.out.CategoryPort;
import com.example.category.domain.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryPersistenceAdapter implements CategoryPort {

    private final CategoryRepository categoryRepository;

    public CategoryPersistenceAdapter(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category create(Category category) {
        CategoryJpaEntity jpaEntity = CategoryMapper.mapToJpaEntity(category);
        CategoryJpaEntity savedJpaEntity = this.categoryRepository.save(jpaEntity);

        return CategoryMapper.mapToDomainEntity(savedJpaEntity);
    }

    @Override
    public Boolean existByName(String name) {
        return this.categoryRepository.existsByName(name);
    }

    @Override
    public Category delete(Long id) {
        CategoryJpaEntity toDelete = this.categoryRepository.findById(id)
                                                            .orElseThrow(() -> new RuntimeException("Category does not exist : \"" + id + "\""));

        this.categoryRepository.delete(toDelete);

        return CategoryMapper.mapToDomainEntity(toDelete);
    }
}
