package com.example.board.category.adapter.in.web;

import com.example.board.category.application.port.in.CategoryUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController("/categories")
public class CategoryController {

    private final CategoryUseCase categoryUseCase;

    public CategoryController(CategoryUseCase categoryUseCase) {
        this.categoryUseCase = categoryUseCase;
    }

    @GetMapping("/health-check")
    public String healthCheck() {
        return LocalDateTime.now().toString();
    }

    @PostMapping("/abc")
    public ResponseEntity<?> createCategory(@RequestBody CategoryRequestDTO categoryRequestDTO) {
        categoryUseCase.createUseCase(categoryRequestDTO.getName());
        return new ResponseEntity<CategoryResponseDTO>(HttpStatus.CREATED);
    }

}
