package com.example.category.adapter.out.persistence;

import org.springframework.stereotype.Component;

import com.example.category.application.port.out.CreateCategoryPort;
import com.example.category.application.port.out.ExistCategoryPort;
import com.example.category.domain.Category;

@Component
public class CategoryPersistenceAdapter  implements ExistCategoryPort, CreateCategoryPort {

	private final CategoryRepository categoryRepository;
	private final CategoryMapper categoryMapper;

	public CategoryPersistenceAdapter(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
		this.categoryRepository = categoryRepository;
		this.categoryMapper = categoryMapper;
	}

	@Override
	public Boolean existCategory(String name) {
		return this.categoryRepository.existsByName(name);
	}

	@Override
	public Category createCategory(Category category) {
		CategoryEntity entity = this.categoryMapper.mapToEntity(category);
		CategoryEntity createdCategory = this.categoryRepository.save(entity);

		return this.categoryMapper.mapToDomain(createdCategory);
	}
}
