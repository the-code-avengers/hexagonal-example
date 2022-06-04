package com.example.category.application;

import org.springframework.stereotype.Service;

import com.example.category.adapter.in.web.link.CreateCategory;
import com.example.category.application.port.in.AddCategoryUseCase;
import com.example.category.application.port.out.CreateCategoryPort;
import com.example.category.application.port.out.ExistCategoryPort;
import com.example.category.domain.Category;

@Service
public class AddCategoryService implements AddCategoryUseCase {

	private final CreateCategoryPort createCategoryPort;
	private final ExistCategoryPort existCategoryPort;

	public AddCategoryService(CreateCategoryPort createCategoryPort, ExistCategoryPort existCategoryPort) {
		this.createCategoryPort = createCategoryPort;
		this.existCategoryPort = existCategoryPort;
	}

	@Override
	public CreateCategory.Response add(String name) {
		Boolean alreadyExist = this.existCategoryPort.existCategory(name);

		if (alreadyExist) {
			String message = "name=" + name + ", 이미 존재 하는 카테고리 입니다.";

			throw new RuntimeException(message);
		}

		Category category = this.createCategoryPort.createCategory(new Category(name));

		return CreateCategory.Response
			.builder()
			.id(category.getId())
			.name(category.getName())
			.build();
	}
}
