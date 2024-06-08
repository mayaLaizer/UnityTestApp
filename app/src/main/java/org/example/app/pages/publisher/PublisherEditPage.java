package org.example.app.pages.publisher;

import org.example.app.pages.AbstractPage;
import org.example.app.utils.ActionBot;
import org.openqa.selenium.WebDriver;

public class PublisherEditPage extends AbstractPage {


    public PublisherEditPage(WebDriver driver) {
        this.driver = driver;
        this.bot = new ActionBot(driver);
    }
}
