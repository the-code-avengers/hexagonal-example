package com.example.category.application.port.in;

import com.example.category.adapter.in.web.link.CreateCategory;

public interface AddCategoryUseCase {
	CreateCategory.Response add(String name);
}
