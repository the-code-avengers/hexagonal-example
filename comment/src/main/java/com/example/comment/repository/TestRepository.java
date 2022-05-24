package com.example.comment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.comment.domain.Comment;

public interface TestRepository extends JpaRepository<Comment, Long> {
	Optional<Comment> findById(Long id);
}
