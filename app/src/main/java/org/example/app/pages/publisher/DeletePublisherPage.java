package org.example.app.pages.publisher;

import org.example.app.pages.AbstractPage;
import org.example.app.utils.ActionBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeletePublisherPage extends AbstractPage {

    private static final By confirmDeleteButton = By.xpath("//section[@data-css='Publisher-bulkDelete-drawer-footer']//button");

    public DeletePublisherPage(WebDriver driver) {
        this.driver = driver;
        this.bot = new ActionBot(driver);
    }

    public PublisherPage clickOnConfirmRemovalButton()
    {
        bot.click(confirmDeleteButton);
        return new PublisherPage(driver);
    }



}
