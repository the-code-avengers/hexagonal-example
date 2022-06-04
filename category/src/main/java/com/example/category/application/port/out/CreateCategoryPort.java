package com.example.category.application.port.out;

import com.example.category.domain.Category;

public interface CreateCategoryPort {

	public Category createCategory(Category category);
}
