package com.example.category.adapter.out.persistence;

import com.example.category.domain.Category;

public class CategoryMapper {

    static Category mapToDomainEntity(CategoryJpaEntity category) {
        return new Category(category.getId(), category.getName());
    }

    static CategoryJpaEntity mapToJpaEntity(Category category) {
        return new CategoryJpaEntity(category.getName());
    }
}
