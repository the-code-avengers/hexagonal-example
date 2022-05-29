package com.example.board.category.application.port.out;

import com.example.board.category.adapter.out.persistence.CategoryEntity;
import com.example.board.category.common.AcceptanceTest;
import com.example.board.category.domain.Category;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

class LoadCategoryPortTest extends AcceptanceTest {

    @Autowired
    private LoadCategoryPort loadCategoryPort;

    @DisplayName("Category Name 으로 Category 불러오기 테스트")
    @Test
    void loadCategory() {
        final String categoryName = "test category";
        final Category testCategory = new Category(categoryName);
        final CategoryEntity categoryEntity = this.toCategoryEntity(testCategory);

        final CategoryEntity createCategory = loadCategoryPort.createCategory(categoryEntity);

        final CategoryEntity loadCategory = loadCategoryPort.loadCategory(categoryName).get();
        assertThat(createCategory).isEqualTo(loadCategory);
    }

    private CategoryEntity toCategoryEntity(Category category) {
        return new CategoryEntity(category.getName());
    }
}