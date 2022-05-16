package com.example.board.category.adapter.in.web;

import com.example.board.category.application.CategoryService;
import com.example.board.category.domain.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping // 아무거나
    public ResponseEntity<?> test() {
        categoryService.useCase();
        return new ResponseEntity<Category>(HttpStatus.OK);
    }

}
