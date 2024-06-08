package org.example.app.pages.publisher;

import org.example.app.pages.AbstractPage;
import org.example.app.utils.ActionBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PublisherCreateNewPage extends AbstractPage {

    private static final By nameText = By.id("name");
    private static final By emailText = By.id("email");
    private static final By saveButton = By.xpath("//button[@type='submit']");

    private static final By showButton = By.xpath("//a[@data-testid='action-show']");

    private static final By deleteButton = By.xpath("//a[@data-testid='action-delete']");

    public PublisherCreateNewPage(WebDriver driver) {
        this.driver = driver;
        this.bot = new ActionBot(driver);
    }

    public void setNameText(String name)
    {
        bot.writeToElement(name,nameText);
    }

    public void setEmailText(String email)
    {
        bot.writeToElement(email,emailText);
    }

    public PublisherPage clickOnSaveButton()
    {
        bot.click(saveButton);
        return new PublisherPage(driver);
    }

    public PublisherShowPage clickOnShowButton()
    {
        bot.click(showButton);
        return new PublisherShowPage(driver);
    }



}
