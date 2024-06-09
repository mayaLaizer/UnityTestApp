package org.example.app.pages;

import org.example.app.pages.Post.PostCreateNewPage;
import org.example.app.pages.Post.PostPage;
import org.example.app.utils.ActionBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmDeletePopUpPage {


    public WebDriver driver;
    public ActionBot bot;

    private static final By confirmButton = By.xpath("//section[contains(@class,'adminjs_Box')]//button[@label='Confirm']");

    private static final By cancelButton = By.xpath("//section[contains(@class,'adminjs_Box')]//button[@label='Cancel']");

    public ConfirmDeletePopUpPage(WebDriver driver) {
        this.driver = driver;
        this.bot = new ActionBot(driver);
    }

    public PostPage clickOnConfirmButton()
    {
        bot.click(confirmButton);
        return new PostPage(driver);
    }
    public PostCreateNewPage clickOnCancelButton()
    {
        bot.click(confirmButton);
        return new PostCreateNewPage(driver);
    }
}
