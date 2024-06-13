package org.example.app.opertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.app.modules.LoginData;
import org.json.JSONObject;
import java.util.Map;


//API Client for all the API calls
import static io.restassured.RestAssured.given;

public class ApiClient {

    private static String baseUri;
    private static String cookie;

    //Initialize with login and create cookie
    public static void initialize(String uri) {

        baseUri = uri;
        LoginData loginData = new LoginData("admin@example.com", "password");

        Response initResponse = given()
                .baseUri("http://localhost:3000")
                .contentType(ContentType.URLENC)
                .formParam("email", loginData.getEmail())
                .formParam("password", loginData.getPassword())
                .post("/admin/login"); // Assuming '/login' is your login or session initialization endpoint

        // Extract cookie from the response
       cookie = "adminjs=" + initResponse.getDetailedCookie("adminjs").getValue();

    }

    //GET API Call
    public static Response get(String endpoint) {
        return RestAssured.given()
                .baseUri(baseUri)
                .header("User-Agent", "Mozilla/5.0 ... Safari/537.36")
                .header("Cookie", cookie)
                .header("Referer", "http://localhost:3000/admin/resources/Publisher")
                .accept("application/json, text/plain, */*")
                .when()
                .get(endpoint);
    }

    //POST API command using FormParams
    public static Response post(String endpoint, Map<String, String> formParams) {


        return RestAssured.given()
                .baseUri(baseUri)
                .header("User-Agent", "Mozilla/5.0 ... Safari/537.36")
                .header("Cookie", cookie)
                .header("Referer", "http://localhost:3000/admin/resources/Publisher")
                .formParams(formParams)
                .when()
                .post(endpoint);
    }

    //POST API call without formParams
    public static Response post(String endpoint) {


        return RestAssured.given()
                .baseUri(baseUri)
                .header("User-Agent", "Mozilla/5.0 ... Safari/537.36")
                .header("Cookie", cookie)
                .header("Referer", "http://localhost:3000/admin/resources/Publisher")
                .when()
                .post(endpoint);
    }

}
