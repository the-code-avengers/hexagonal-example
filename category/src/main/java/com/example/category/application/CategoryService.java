package com.example.category.application;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.category.adapter.in.web.link.CreateCategory;
import com.example.category.adapter.out.persistence.CategoryRepository;
import com.example.category.domain.Category;

@Service
public class CategoryService {
	final CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public CreateCategory.Response save(String name) {
		Category category = this.categoryRepository.save(new Category(name));

		return CreateCategory.Response
			.builder()
			.id(category.getId())
			.name(category.getName())
			.build();
	}

	public Optional<Category> findByIdOrEmpty(Long id) {
		return this.categoryRepository.findById(id);
	}
}
