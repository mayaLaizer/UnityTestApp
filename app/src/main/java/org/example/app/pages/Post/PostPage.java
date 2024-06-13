package org.example.app.pages.Post;

import org.example.app.pages.AbstractPage;
import org.example.app.pages.publisher.DeletePublisherPage;
import org.example.app.pages.publisher.PublisherCreateNewPage;
import org.example.app.utils.ActionBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/* POST List Page object */
public class PostPage extends AbstractPage {

    private static final By postTable = By.xpath("//section[@data-css='Post-list-table-wrapper']//tbody[@data-css='Post-table-body']");

    private static final By deleteAllButton = By.xpath("//section//a[@data-testid='action-bulkDelete']");

    public PostPage(WebDriver driver) {
        this.driver = driver;
        this.bot = new ActionBot(driver);
    }

    public PostCreateNewPage clickOnCreateFirstRecordButton() {
        WebElement elem = driver.findElement(createFirstRecordButton);
        if (elem.isDisplayed()) {
            bot.click(createFirstRecordButton);
            return new PostCreateNewPage(driver);
        } else {
            bot.click(createNewButton);
            return new PostCreateNewPage(driver);
        }
    }

    public List<WebElement> getAllRowInTable() {
        List<WebElement> tableRows = new ArrayList<>();

        WebElement table = driver.findElement(postTable);

        tableRows = table.findElements(By.xpath(".//tr"));

        for (WebElement items : tableRows)
            System.out.println(items.getText());

        return tableRows;
    }

    //click on selected row
    public PostEditPage selectTableRow(String title) {
        List<WebElement> postList = getAllRowInTable();

        for (WebElement item : postList) {
            if (item.getText().contains(title)) {

                bot.click(item);
                return new PostEditPage(driver);
            }
        }
        return null;
    }

    public void selectPostRaw(String name) {
        WebElement table = driver.findElement(By.xpath("//table[@data-css='Post-table']"));
        List<WebElement> tableRows = table.findElements(By.tagName("tr"));

        for (WebElement row : tableRows) {

            List<WebElement> cells = row.findElements(By.tagName("td"));

            // Assuming we are searching for a row containing a specific cell value
            for (WebElement cell : cells) {
                if (cell.getText().equals(name)) {
                    System.out.println("Row found: " + row.getText());
                    row.findElement(By.xpath(".//input[@type='checkbox']//..//a")).click();
                }
            }
        }
    }

    public WebElement getPostRaw(String name) {
        WebElement table = driver.findElement(By.xpath("//table[@data-css='Post-table']"));
        List<WebElement> tableRows = table.findElements(By.tagName("tr"));

        for (WebElement row : tableRows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));

            // Assuming we are searching for a row containing a specific cell value
            for (WebElement cell : cells) {
                if (cell.getText().equals(name)) {
                    System.out.println("Row found: " + row.getText());
                    return row;

                }
            }
        }
        System.out.println("Row was not found");
        return null;
    }

    public DeletePostPage clickOnDeleteAllButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(deleteAllButton));
        bot.click(deleteAllButton);
        return new DeletePostPage(driver);
    }

}
