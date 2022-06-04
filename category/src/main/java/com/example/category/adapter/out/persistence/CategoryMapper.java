package com.example.category.adapter.out.persistence;

import org.springframework.stereotype.Component;

import com.example.category.domain.Category;

@Component
public class CategoryMapper {
	public CategoryEntity mapToEntity(Category category){
		return new CategoryEntity(category.getName());
	}

	public Category mapToDomain(CategoryEntity categoryEntity){
		return new Category(categoryEntity.getId(), categoryEntity.getName());
	}

}
