package com.example.category.adapter.in.web;

import com.example.category.application.port.in.CreateCategoryUseCase;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CreateCategoryUseCase createCategoryUseCase;

    public CategoryController(CreateCategoryUseCase createCategoryUseCase) {
        this.createCategoryUseCase = createCategoryUseCase;
    }

    @GetMapping("/test")
    public String healthCheck() {
        return LocalDateTime.now().toString();
    }

    @PostMapping
    public CategoryResponse create(@RequestBody CreateCategoryRequest request) {
        return this.createCategoryUseCase.create(request.getName());
    }
}
