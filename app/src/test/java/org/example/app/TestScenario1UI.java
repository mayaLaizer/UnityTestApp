package org.example.app;

import org.example.app.modules.JsonData;
import org.example.app.pages.LoginPage;
import org.example.app.pages.MainPage;
import org.example.app.pages.Post.PostCreateNewPage;
import org.example.app.pages.Post.PostPage;
import org.example.app.pages.publisher.PublisherCreateNewPage;
import org.example.app.pages.publisher.PublisherPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.List;

public class TestScenario1UI extends TestBase{


    @Test
    public void createPublisher() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = loginPage.clickOnLoginButton();
        mainPage.clickOnHappyFolderDD();

        PublisherPage publisherPage = mainPage.clickOnPublisherButton();
        PublisherCreateNewPage publisherCreateNewPage = publisherPage.clickOnCreateFirstRecordButton();

        publisherCreateNewPage.setNameText("Maya");
        publisherCreateNewPage.setEmailText("MayaLaizer@gmail.com");
        publisherPage = publisherCreateNewPage.clickOnSaveButton();




        System.out.println("test.....");


    }

    @Test
    public void createPost() throws InterruptedException {

        JsonData jsonData1 = new JsonData("111","Test1",  true);
        JsonData jsonData2 = new JsonData("222","Test2",  false);

        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = loginPage.clickOnLoginButton();
        mainPage.clickOnHappyFolderDD();

        PostPage postPage = mainPage.clickOnPostButton();
        PostCreateNewPage postCreateNewPage = postPage.clickOnCreateFirstRecordButton();

        postCreateNewPage.setTitleText("Test1");
        postCreateNewPage.setContent("Content1");

        postCreateNewPage.clickOnAddNewJsonButton();
        postCreateNewPage.clickOnAddNewJsonButton();

  //      postCreateNewPage.setJsonElement(jsonData1, 1);
        postCreateNewPage.setJsonElement(jsonData2, 2);
 //       List<WebElement> jsonElement = postCreateNewPage.getJsonElement(1);








        System.out.println("test.....");


    }


}
