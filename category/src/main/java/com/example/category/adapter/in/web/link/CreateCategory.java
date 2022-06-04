package com.example.category.adapter.in.web.link;

import lombok.Builder;

public sealed interface CreateCategory {

	record Request(
		String name
	) implements CreateCategory {
	}

	record Response(
		Long id,
		String name
	) implements CreateCategory {
		@Builder
		public Response {

		}
	}
}
