package com.example.category.adapter.in.web;

import com.example.category.application.port.in.CreateCategoryUseCase;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CreateCategoryUseCase createCategoryUseCase;

    public CategoryController(CreateCategoryUseCase createCategoryUseCase) {
        this.createCategoryUseCase = createCategoryUseCase;
    }

    @PostMapping
    public CategoryResponse create(@Valid @RequestBody CreateCategoryRequest request) {
        return this.createCategoryUseCase.create(request.getName());
    }

    @DeleteMapping("/{id}")
    public CategoryResponse delete(@PathVariable Long id) {
        return this.createCategoryUseCase.delete(id);
    }
}
