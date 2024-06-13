package org.example.app.pages.publisher;

import org.example.app.pages.AbstractPage;
import org.example.app.utils.ActionBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PublisherPage extends AbstractPage {

    private static final By deleteAllButton = By.xpath("//section//a[@data-testid='action-bulkDelete']");

    public PublisherPage(WebDriver driver) {
        this.driver = driver;
        this.bot = new ActionBot(driver);
    }

    public PublisherCreateNewPage clickOnCreateFirstRecordButton() {
        WebElement elem = driver.findElement(createFirstRecordButton);
        if (elem.isDisplayed()) {
            bot.click(createFirstRecordButton);
            return new PublisherCreateNewPage(driver);
        } else {
            bot.click(createNewButton);
            return new PublisherCreateNewPage(driver);
        }

    }

    public DeletePublisherPage clickOnDeleteAllButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(deleteAllButton));
        bot.click(deleteAllButton);
        return new DeletePublisherPage(driver);

    }

    public void selectPublisherRaw(String name) {
        WebElement table = driver.findElement(By.xpath("//table"));
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

}
