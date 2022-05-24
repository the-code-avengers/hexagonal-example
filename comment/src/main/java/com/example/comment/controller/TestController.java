package com.example.comment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.comment.service.TestService;

@RestController
public class TestController {
	final TestService service;

	public TestController(TestService service) {
		this.service = service;
	}

	@GetMapping("/hello")
	public String helloWorld(){


		return "hello world";
	}
}
