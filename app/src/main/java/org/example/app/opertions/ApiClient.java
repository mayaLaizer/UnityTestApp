package org.example.app.opertions;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiClient {

    private static String baseUri;

    public static void initialize(String uri) {
        baseUri = uri;
    }

    public static Response get(String endpoint) {
        return RestAssured.given()
                .baseUri(baseUri)
                .when()
                .get(endpoint);
    }

    // Add more methods for POST, PUT, DELETE if needed
}
