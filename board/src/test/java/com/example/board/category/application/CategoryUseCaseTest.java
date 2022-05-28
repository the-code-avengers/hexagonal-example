package com.example.board.category.application;

import com.example.board.category.adapter.in.web.CategoryResponse;
import com.example.board.category.application.port.in.CategoryUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class CategoryUseCaseTest {

    @Autowired
    CategoryUseCase categoryUseCase;

    @Test
    void createUseCase() {
        final String 테스트카테고리 = "테스트카테고리";
        final CategoryResponse createdCategoryResponse = categoryUseCase.createUseCase(테스트카테고리);
        assertThat(createdCategoryResponse).isEqualTo(new CategoryResponse(1L, 테스트카테고리));
    }
}