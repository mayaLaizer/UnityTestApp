package org.example.app.pages.Post;

import org.example.app.pages.AbstractPage;
import org.example.app.utils.ActionBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*Post Bulk Delete confirm page*/
public class DeletePostPage extends AbstractPage {

    private static final By confirmDeleteButton = By.xpath("//section[@data-css='Post-bulkDelete-drawer-footer']//button");

    public DeletePostPage(WebDriver driver) {
        this.driver = driver;
        this.bot = new ActionBot(driver);
    }

    public PostPage clickOnConfirmRemovalButton()
    {
        bot.click(confirmDeleteButton);
        return new PostPage(driver);
    }

}
