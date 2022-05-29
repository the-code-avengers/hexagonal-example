package com.example.board.category.application;

import com.example.board.category.adapter.in.web.CategoryResponseDTO;
import com.example.board.category.adapter.out.persistence.CategoryEntity;
import com.example.board.category.application.port.in.CategoryUseCase;
import com.example.board.category.application.port.out.LoadCategoryPort;
import com.example.board.category.domain.Category;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryService implements CategoryUseCase {

    private LoadCategoryPort loadCategoryPort;

    public CategoryService(LoadCategoryPort loadCategoryPort) {
        this.loadCategoryPort = loadCategoryPort;
    }

    @Override
    public CategoryResponseDTO createUseCase(String categoryName) {
        if (loadCategoryPort.loadCategory(categoryName).isPresent()) {
            throw new RuntimeException(String.format("이미 존재하는 카테고리 이름입니다 (%s)", categoryName));
        }

        Category category = new Category(categoryName);
        final CategoryEntity categoryEntity = this.toCategoryEntity(category);

        final CategoryEntity savedCategory = loadCategoryPort.createCategory(categoryEntity);
        return this.toCategoryResponse(savedCategory);
    }

    @Override
    public Long deleteUseCase(Long categoryId) {
        CategoryEntity loadCategory = loadCategoryPort.loadCategory(categoryId);
        loadCategoryPort.deleteCategory(loadCategory);
        return loadCategory.getId();
    }

    private CategoryResponseDTO toCategoryResponse(CategoryEntity categoryEntity) {
        return new CategoryResponseDTO(categoryEntity.getId(),
                                       categoryEntity.getName());
    }

    private CategoryEntity toCategoryEntity(Category category) {
        return new CategoryEntity(category.getName());
    }
}
