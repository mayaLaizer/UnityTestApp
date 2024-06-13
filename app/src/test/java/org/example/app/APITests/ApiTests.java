package org.example.app.APITests;


import io.restassured.response.Response;
import org.example.app.enums.PostStatusSelection;
import org.example.app.modules.Post;
import org.example.app.modules.Publisher;
import org.example.app.opertions.ApiClient;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class ApiTests {

    private  String postId;

    private String publisherId;
    @BeforeClass
    public static void setup() {
        ApiClient.initialize("http://localhost:3000");
    }

    @Test
    public void TestPostPublisher()
    {
        //Create new object for publisher and post
        Publisher publisher = new Publisher("Maya", "Maya@gmail.com");
        Post post = new Post("Book Publisher", "Post Content", PostStatusSelection.ACTIVE, true, "Maya@gmail.com");

        //create publisher payload
        Map<String, String> publisherPayload = new HashMap<>();

        publisherPayload.put("name", publisher.getName());
        publisherPayload.put("email", publisher.getEmail());

        //Step 1 : create publisher
        System.out.println("Step1 : Create Publisher");
        Response response = ApiClient.post("/admin/api/resources/Publisher/actions/new",publisherPayload);
        publisherId = response.jsonPath().getString("record.id");
        System.out.println(response.asString());

        //Create Post payload
        Map<String, String> postPayload = new HashMap<>();
        postPayload.put("title", post.getTitle());
      //  postPayload.put("content", "Post Content");
        postPayload.put("content", post.getContent().toString());
        postPayload.put("status", PostStatusSelection.ACTIVE.toString());
        postPayload.put("someJson.0.number","3");
        postPayload.put("someJson.0.boolean" , "true");
        postPayload.put("someJson.0.date" ,"2024-06-23T21:00:00.000Z");
        postPayload.put("published", String.valueOf(post.isPublished()));
        postPayload.put("publisher", publisherId);

        //Create Post
        System.out.println("Step 2  : Create Post Status = Active , Published = true");
        response = ApiClient.post("/admin/api/resources/Post/actions/new",postPayload);
        postId = response.jsonPath().getString("record.id");
        System.out.println(response.asString());

        //Update Status
        System.out.println("Step 3  : update Status = REMOVED");
        postPayload.put("status", PostStatusSelection.REMOVED.toString());
        response = ApiClient.post("/admin/api/resources/Post/records/"+postId+"/edit",postPayload);
        System.out.println(response.asString());

        System.out.println("Step 4  : Validate the status was changed");
        Assert.assertEquals(response.jsonPath().getString("record.params.status"),"REMOVED");


    }
    @AfterClass
    public void cleanUp()
    {
        //delete the items created in the test
        Response response = ApiClient.post("admin/api/resources/Post/records/"+postId+"/delete");
        System.out.println(response.asString());

        response = ApiClient.post("/admin/api/resources/Publisher/records/"+publisherId+"/delete");
        System.out.println(response.asString());
    }

}
