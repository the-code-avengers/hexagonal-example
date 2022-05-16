package com.example.board.category.adapter.out.persistence;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CategoryEntity {
    @Id
    private int id;
    private String name;
}
