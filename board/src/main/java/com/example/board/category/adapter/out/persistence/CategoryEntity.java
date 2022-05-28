package com.example.board.category.adapter.out.persistence;

import javax.persistence.*;

@Entity(name = "category")
@Table(name = "category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    public CategoryEntity() {
    }

<<<<<<< Updated upstream:board/src/main/java/com/example/board/category/adapter/out/persistence/CategoryEntity.java
    public CategoryEntity(String name) {
        this.name = name;
    }
=======
	public Category(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}
>>>>>>> Stashed changes:category/src/main/java/com/example/category/domain/Category.java

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
