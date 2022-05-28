package com.example.category.adapter.in.web;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.category.adapter.in.web.link.CreateCategory;
import com.example.category.application.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	final CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@PostMapping
	public CreateCategory.Response createSample(@Valid @RequestBody CreateCategory.Request request) {
		return this.categoryService.save(request.name());
	}
}
