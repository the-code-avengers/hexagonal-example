package com.example.category.adapter.out.persistence;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class CategoryJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public CategoryJpaEntity() {
    }

    public CategoryJpaEntity(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
