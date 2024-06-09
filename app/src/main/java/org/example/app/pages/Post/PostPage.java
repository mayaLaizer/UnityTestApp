package org.example.app.pages.Post;

import org.example.app.pages.AbstractPage;
import org.example.app.pages.publisher.PublisherCreateNewPage;
import org.example.app.utils.ActionBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class PostPage extends AbstractPage {

    private static final By postTable = By.xpath("//section[@data-css='Post-list-table-wrapper']//tbody[@data-css='Post-table-body']");

    private static final By postTableTr = By.xpath("//section[@data-css='Post-list-table-wrapper']//tbody//tr");

    public PostPage(WebDriver driver) {
        this.driver = driver;
        this.bot = new ActionBot(driver);
    }

    public PostCreateNewPage clickOnCreateFirstRecordButton()
    {
        WebElement elem = driver.findElement(createFirstRecordButton);
        if(elem.isDisplayed())
        {
            bot.click(createFirstRecordButton);
            return new PostCreateNewPage(driver);
        }
        else
        {
            bot.click(createNewButton);
            return new PostCreateNewPage(driver);
        }

    }

    public List<WebElement> getAllRowInTable()
    {
        List<WebElement> tableRows = new ArrayList<>();

        WebElement table = driver.findElement(postTable);

       tableRows =  table.findElements(By.xpath(".//tr"));

       for(WebElement items : tableRows)
           System.out.println(items.getText());

        return tableRows;
    }

    //click on selected row
    public PostEditPage selectTableRow(String title)
    {
        List<WebElement> postList = getAllRowInTable();

        for(WebElement item : postList)
        {
            if(item.getText().contains(title))
            {

                bot.click(item);
                return new PostEditPage(driver);

            }
        }
        return null;

    }

    public String getTableColumnValue(String title)
    {
        List<WebElement> postList = getAllRowInTable();
        List<WebElement> tds = new ArrayList<>();

        for(WebElement item : postList)
        {
            if(item.getText().contains(title))
            {
                tds = item.findElements(By.xpath(".//td"));

            }



        }
        System.out.println(tds);
        return "";

    }


}
