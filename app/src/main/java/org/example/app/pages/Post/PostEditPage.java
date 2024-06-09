package org.example.app.pages.Post;

import org.example.app.pages.AbstractPage;
import org.example.app.utils.ActionBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PostEditPage extends PostCreateNewPage {

    private static final By editPostButton = By.xpath("//section[contains(@class,'adminjs_Box')]//a[@data-testid='action-edit']");
    private static final By showPostButton = By.xpath("//section[contains(@class,'adminjs_Box')]//a[@data-testid='action-show']");

    private static final By deletePostButton = By.xpath("//section[contains(@class,'adminjs_Box')]//a[@data-testid='action-delete']");


    public PostEditPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.bot = new ActionBot(driver);
    }

    public void clickOnEditButton()
    {
        bot.click(editPostButton);
    }

    public void clickOnDeleteButton()
    {
        bot.click(deletePostButton);
    }

    public void clickOnShowButton()
    {
        bot.click(showPostButton);
    }
}
