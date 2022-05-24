package com.example.comment.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.comment.domain.Comment;
import com.example.comment.repository.TestRepository;

@Service
public class TestService {
	final TestRepository repository;

	public TestService(TestRepository repository) {
		this.repository = repository;
	}

	public Optional<Comment> findByIdOrEmpty(Long id) {
		return this.repository.findById(id);
	}
}
