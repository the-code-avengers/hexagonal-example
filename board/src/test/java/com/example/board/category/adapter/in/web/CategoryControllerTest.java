package com.example.board.category.adapter.in.web;

import com.example.board.category.common.AcceptanceTest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


class CategoryControllerTest extends AcceptanceTest {
    private static final String TEST_NAME_VALUE = "test category";

    private Map<String, String> params = new HashMap<>();

    @DisplayName("카테고리 생성 API 테스트")
    @Test
    void createCategory() {
        params.put("name", TEST_NAME_VALUE);;
        final ExtractableResponse<Response> response = 카테고리_생성(params);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(response.jsonPath().getString("name")).isEqualTo(TEST_NAME_VALUE);
    }

    private ExtractableResponse<Response> 카테고리_생성(Map<String, String> params) {
        return RestAssured.given().log().all()
                        .body(params).log().all()
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .when()
                        .post("/categories")
                    .then()
                        .log().all().extract();
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

    @DisplayName("카테고리 삭제 API 테스트")
    @Test
    void deleteCategory() {
        params.put("name", TEST_NAME_VALUE);;
        final ExtractableResponse<Response> response = 카테고리_생성(params);
        final Integer id = response.jsonPath().get("id");

        final ExtractableResponse<Response> extract =
                RestAssured.given().pathParam("id", id).log().all()
                .when().delete("/categories/{id}")
                .then().log().all().extract();

        assertThat(extract.statusCode()).isEqualTo(HttpStatus.OK.value());

    }
}