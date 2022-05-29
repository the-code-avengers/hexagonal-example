package com.example.board.category.adapter.out.persistence;

import com.example.board.category.application.port.out.LoadCategoryPort;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CategoryPersistenceAdapter implements LoadCategoryPort {

    private CategoryRepository categoryRepository;

    public CategoryPersistenceAdapter(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryEntity createCategory(CategoryEntity categoryEntity) {
        return categoryRepository.save(categoryEntity);
    }

    @Override
    public CategoryEntity loadCategory(Long categoryId) {
        return categoryRepository.findById(categoryId)
                                  .orElseThrow(() -> new RuntimeException(
                                          String.format("ID %L에 해당 카테고리를 찾을 수 없습니다. ", categoryId))
                                  );
    }

    @Override
    public Optional<CategoryEntity> loadCategory(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public void deleteCategory(CategoryEntity loadCategory) {
        categoryRepository.delete(loadCategory);
    }
}
