package org.example.app.pages;

import org.example.app.pages.Post.PostPage;
import org.example.app.pages.publisher.PublisherPage;
import org.example.app.utils.ActionBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends AbstractPage {

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.bot = new ActionBot(driver);
    }

    public void clickOnHappyFolderDD()
    {
        bot.click(happyFolderDD);
    }

    public PublisherPage clickOnPublisherButton()
    {
        bot.click(publisherButton);
        return new PublisherPage(driver);
    }

    public PostPage clickOnPostButton()
    {
        bot.click(postButton);
        return new PostPage(driver);
    }
}
