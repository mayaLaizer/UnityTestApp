package org.example.app.pages.Post;

import org.example.app.modules.JsonData;
import org.example.app.pages.AbstractPage;
import org.example.app.utils.ActionBot;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PostCreateNewPage extends AbstractPage {


    private static final By titleText = By.id("title");
    private static final By contentText = By.id("content");

    private static final By addNewJsonButton = By.xpath("//button[@data-testid='someJson-add']");

    private static final By publishedCheckBox = By.id("published");

    private static final By statusSelectionComboBox = By.xpath("//section[@data-testid='property-edit-status']//input");

    private static final By publisherComboBox = By.xpath("//section[@data-testid='property-edit-publisher']//input");

    private static final By saveButton = By.xpath("//button[@type='submit']");

    private static final By someJsonSection = By.xpath("//div[@data-testid='property-edit-someJson']");

    private static final By someJsonData = By.xpath("//section[@data-rfd-droppable-id='someJson']/div");

    private static final By jsonDataLabel = By.xpath("//section[@data-rfd-droppable-id='someJson']/div//div/div/label");





    public PostCreateNewPage(WebDriver driver) {
        this.driver = driver;
        this.bot = new ActionBot(driver);
    }

    public void setTitleText(String title)
    {
        bot.writeToElement(title,titleText);
    }
    public void setContent(String content)
    {
        bot.writeToElement(content,contentText);
    }

    public void clickOnAddNewJsonButton()
    {
        bot.click(addNewJsonButton);
    }

    public PostPage clickOnSaveButton()
    {
        bot.click(saveButton);
        return new PostPage(driver);
    }

    public List<WebElement> getJsonElement(int num)
    {
        WebElement jsonList = driver.findElement(someJsonSection);
        List<WebElement> jsonDataList = jsonList.findElements(someJsonData);
        int jsonSize = jsonDataList.size();

  /*      System.out.println(jsonDataList.get(0).getText());
        System.out.println("-------------------------------");*/
        String id = jsonDataList.get(num-1).getAttribute("data-testid");
       List<WebElement> jsonDataEntity = jsonDataList.get(num-1).findElements(By.xpath("//section[contains(@data-testid,'"+id+"')]"));
    //   String label = jsonDataList.get(0).findElement(By.tagName("label")).getText();



        for(WebElement entity: jsonDataEntity )
        {
            System.out.println(entity.getText());
        }
        return jsonDataEntity;

    }

    public void setJsonElement(JsonData jsonData,int number)
    {

        List<WebElement> jsonDataEntity = getJsonElement(number);

        try {
            bot.writeToElement(jsonData.getSomeJsonNumber(),jsonDataEntity.get(0).findElement(By.xpath("//input[contains(@id,'number')]")));
            bot.writeToElement(Keys.TAB,jsonDataEntity.get(0).findElement(By.xpath("//input[contains(@id,'number')]")));
            jsonDataEntity = getJsonElement(number);
            bot.writeToElement(jsonData.getSomeJsonString(),jsonDataEntity.get(1).findElement(By.xpath("//input[contains(@id,'string')]")));
            bot.writeToElement(Keys.TAB,jsonDataEntity.get(1).findElement(By.xpath("//input[contains(@id,'string')]")));


            if(jsonData.isSomeJsonBoolean())
            {
                jsonDataEntity = getJsonElement(number);
                bot.click(jsonDataEntity.get(2).findElement(By.xpath("//div//span//input[contains(@id,'boolean')]//..//a")));
            }

        } catch (Exception e) {




        }


    }

}


