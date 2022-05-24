package com.example.comment.domain;

import javax.persistence.*;

@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "title", columnDefinition = "VARCHAR(50)")
	private String title;

	protected Comment() {
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}


}
