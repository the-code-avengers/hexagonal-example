package com.example.board.category.adapter.out.persistence;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CategoryEntity {
    @Id
    private Long id;
    private String name;
}
