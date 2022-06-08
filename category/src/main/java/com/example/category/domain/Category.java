package com.example.category.domain;

public class Category {

    private final Long id;

    private final String name;

    public Category(String name) {
        this.id = null;
        this.name = name;
    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
