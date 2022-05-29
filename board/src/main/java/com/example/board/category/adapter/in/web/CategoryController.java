package com.example.board.category.adapter.in.web;

import com.example.board.category.application.port.in.CategoryUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryUseCase categoryUseCase;

    public CategoryController(CategoryUseCase categoryUseCase) {
        this.categoryUseCase = categoryUseCase;
    }

    @GetMapping("/health-check")
    public String healthCheck() {
        return LocalDateTime.now().toString();
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> createCategory(@RequestBody CategoryRequestDTO categoryRequestDTO) {
        final CategoryResponseDTO response = categoryUseCase.createUseCase(categoryRequestDTO.getName());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable(name = "id") Long categoryId) {
        categoryUseCase.deleteUseCase(categoryId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
