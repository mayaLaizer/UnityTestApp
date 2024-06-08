package org.example.app.pages.Post;

import org.example.app.pages.AbstractPage;
import org.example.app.pages.publisher.PublisherCreateNewPage;
import org.example.app.utils.ActionBot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PostPage extends AbstractPage {

    public PostPage(WebDriver driver) {
        this.driver = driver;
        this.bot = new ActionBot(driver);
    }

    public PostCreateNewPage clickOnCreateFirstRecordButton()
    {
        WebElement elem = driver.findElement(createFirstRecordButton);
        if(elem.isDisplayed())
        {
            bot.click(createFirstRecordButton);
            return new PostCreateNewPage(driver);
        }
        else
        {
            bot.click(createNewButton);
            return new PostCreateNewPage(driver);
        }

    }


}
