package com.example.board.category.application;

import com.example.board.category.adapter.in.web.CategoryResponseDTO;
import com.example.board.category.application.port.in.CategoryUseCase;
import com.example.board.category.application.port.out.LoadCategoryPort;
import com.example.board.category.common.AcceptanceTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CategoryUseCaseTest extends AcceptanceTest {

    @Autowired
    CategoryUseCase categoryUseCase;

    @Autowired
    LoadCategoryPort loadCategoryPort;

    @DisplayName("카테고리 생성 UseCase 테스트")
    @Test
    void createUseCase() {
        final String 테스트카테고리 = "테스트카테고리";
        final CategoryResponseDTO createdCategoryResponseDTO = categoryUseCase.createUseCase(테스트카테고리);
        assertThat(createdCategoryResponseDTO).isEqualTo(new CategoryResponseDTO(1L, 테스트카테고리));
    }

    @DisplayName("카테고리 삭제 UseCase 테스트")
    @Test
    void deleteUseCase() {
        final String 테스트카테고리 = "테스트카테고리";
        final CategoryResponseDTO createdCategoryResponseDTO = categoryUseCase.createUseCase(테스트카테고리);
        final Long id = createdCategoryResponseDTO.getId();
        categoryUseCase.deleteUseCase(id);

        assertThrows(RuntimeException.class, () ->
                loadCategoryPort.loadCategory(id)
        );
    }
}