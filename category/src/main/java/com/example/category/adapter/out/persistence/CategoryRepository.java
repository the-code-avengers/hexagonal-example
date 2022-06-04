package com.example.category.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

 interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
	boolean existsByName(String name);
}
