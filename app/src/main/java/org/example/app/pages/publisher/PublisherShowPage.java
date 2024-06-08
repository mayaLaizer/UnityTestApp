package org.example.app.pages.publisher;

import org.example.app.pages.AbstractPage;
import org.example.app.utils.ActionBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PublisherShowPage extends AbstractPage {



    public PublisherShowPage(WebDriver driver) {
        this.driver = driver;
        this.bot = new ActionBot(driver);
    }

    public PublisherEditPage clickOnEditButton()
   {
        bot.click(editButton);
        return new PublisherEditPage(driver);
   }
}
