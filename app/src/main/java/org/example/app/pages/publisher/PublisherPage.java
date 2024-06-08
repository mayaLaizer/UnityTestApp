package org.example.app.pages.publisher;

import org.example.app.pages.AbstractPage;
import org.example.app.utils.ActionBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PublisherPage extends AbstractPage {


 //   private static final By createFirstRecordButton = By.xpath("//button[@data-testid='action-new']");

    public PublisherPage(WebDriver driver) {
        this.driver = driver;
        this.bot = new ActionBot(driver);
    }

    public PublisherCreateNewPage clickOnCreateFirstRecordButton()
    {
        WebElement elem = driver.findElement(createFirstRecordButton);
        if(elem.isDisplayed())
        {
            bot.click(createFirstRecordButton);
            return new PublisherCreateNewPage(driver);
        }
        else
        {
            bot.click(createNewButton);
            return new PublisherCreateNewPage(driver);
        }

    }


}
