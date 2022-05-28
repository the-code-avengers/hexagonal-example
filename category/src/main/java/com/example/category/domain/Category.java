package com.example.category.domain;

import java.time.OffsetDateTime;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", columnDefinition = "VARCHAR(50)", unique = true)
	private String name;

	@CreatedDate
	@Column(name = "created_at", columnDefinition = "TIMESTAMP", updatable = false)
	private final OffsetDateTime createdAt = OffsetDateTime.now();

	@LastModifiedDate
	@Column(name = "update_at", columnDefinition = "TIMESTAMP")
	private OffsetDateTime updatedAt = createdAt;

	protected Category() {
	}

	public Category(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public OffsetDateTime getCreatedAt() {
		return createdAt;
	}

	public OffsetDateTime getUpdatedAt() {
		return updatedAt;
	}
}
