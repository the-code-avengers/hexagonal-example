package com.example.board.category.adapter.in.web;

import com.example.board.category.application.port.in.CategoryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryUseCase categoryUseCase;

    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody CategoryRequest categoryRequest) {
        categoryUseCase.createUseCase(categoryRequest.getName());
        return new ResponseEntity<CategoryResponse>(HttpStatus.OK);
    }

}
