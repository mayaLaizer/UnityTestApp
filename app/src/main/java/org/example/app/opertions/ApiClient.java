package org.example.app.opertions;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

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

    public static Response post(String endpoint, String body)
    {
        return RestAssured.given()
                .baseUri(baseUri).body(body)
                .when()
                .post(endpoint);
    }



    // Add more methods for POST, PUT, DELETE if needed
}
