package org.example.app.UITests;

import org.example.app.enums.PostStatusSelection;
import org.example.app.modules.JsonData;
import org.example.app.modules.Post;
import org.example.app.modules.Publisher;
import org.example.app.opertions.DatePicker;
import org.example.app.pages.LoginPage;
import org.example.app.pages.MainPage;
import org.example.app.pages.Post.*;
import org.example.app.pages.publisher.PublisherCreateNewPage;
import org.example.app.pages.publisher.PublisherPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestScenario1UI extends TestBase {


    @Test
    public void testScenario1UI() throws InterruptedException {

        Publisher publisher = new Publisher("Maya", "Maya@gmail.com");
        Post post = new Post("Book Publisher", "Post Content", PostStatusSelection.ACTIVE, true, "Maya@gmail.com");
        JsonData jsonData1 = new JsonData("111", "Test1", true);

        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = loginPage.clickOnLoginButton();
        mainPage.clickOnHappyFolderDD();

        System.out.println("Step 1 : Create publisher");
        PublisherPage publisherPage = mainPage.clickOnPublisherButton();
        PublisherCreateNewPage publisherCreateNewPage = publisherPage.clickOnCreateFirstRecordButton();

        publisherCreateNewPage.setNameText(publisher.getName());
        publisherCreateNewPage.setEmailText(publisher.getEmail());
        publisherCreateNewPage.clickOnSaveButton();

        System.out.println("Step 2 : Create post");
        PostPage postPage = mainPage.clickOnPostButton();
        PostCreateNewPage postCreateNewPage = postPage.clickOnCreateFirstRecordButton();

        postCreateNewPage.setTitleText(post.getTitle());
        postCreateNewPage.setContent(post.getContent());

        System.out.println("Step 2a : Set SomeJson Data");
        postCreateNewPage.clickOnAddNewJsonButton();
        postCreateNewPage.setJsonElement(jsonData1, 1);
        DatePicker.selectDate(driver, "June 2025", "5");

        postCreateNewPage.selectStatus(post.setPostStatusSelection(PostStatusSelection.ACTIVE));
        postCreateNewPage.clickOnPublishedCheckBox(true);
        postCreateNewPage.selectPublisher(post.getPublisher());

        System.out.println("Step 3 : Click On Save");
        postPage = postCreateNewPage.clickOnSaveButton();

        System.out.println("Step 4 : Select the row for edit");
        PostEditPage postEditPage = postPage.selectTableRow(post.getTitle());
        postEditPage.clickOnEditButton();

        System.out.println("Step 4 : Change Status for REMOVED");
        postEditPage.selectStatus(post.setPostStatusSelection(PostStatusSelection.REMOVED));
        postPage = postEditPage.clickOnSaveButton();

        WebElement row = postPage.getPostRaw(post.getTitle());
        Assert.assertTrue(row.getText().contains("REMOVED"));

        System.out.println("test.....");

    }

}
