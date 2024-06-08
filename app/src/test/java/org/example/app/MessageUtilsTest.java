/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example.app;

import io.restassured.response.Response;
import org.example.app.opertions.ApiClient;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MessageUtilsTest {

    private ApiClient apiClient;

    @BeforeAll
    public static void setup() {
        ApiClient.initialize("https://jsonplaceholder.typicode.com");
    }



    @Test
    public void testGetRequest() {
        Response response = ApiClient.get("/posts/1");

        assertThat(response.statusCode(), equalTo(200));
        assertThat(response.jsonPath().getInt("userId"), equalTo(1));
        assertThat(response.jsonPath().getInt("id"), equalTo(1));
        assertThat(response.jsonPath().getString("title"), equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));

        System.out.println(response.asString());
    }
}