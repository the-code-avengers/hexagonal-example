package com.example.board.category.adapter.in.web;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@ExtendWith(SpringExtension.class)
class CategoryControllerTest {

    @Test
    void createCategory() {
        final String TEST_NAME_VALUE = "test category";

        final Map<String, String> params = new HashMap<>();
        params.put("name", TEST_NAME_VALUE);

        final ExtractableResponse<Response> response =
                RestAssured.given().log().all()
                                .body(params).log().all()
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                            .when()
                                .post("/categories")
                            .then()
                                .log().all().extract();

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
//        assertThat(response.jsonPath().getString("name")).isEqualTo(TEST_NAME_VALUE);
    }

    @Test
    void healthCheck() {

        final ExtractableResponse<Response> response =
                RestAssured.given().log().all()
                        .when()
                        .get("/categories/health-check")
                        .then()
                        .log().all().extract();

        System.out.println(response);
    }
}