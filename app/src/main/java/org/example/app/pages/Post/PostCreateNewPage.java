package org.example.app.pages.Post;

import org.example.app.enums.PostStatusSelection;
import org.example.app.modules.JsonData;
import org.example.app.pages.AbstractPage;
import org.example.app.utils.ActionBot;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class PostCreateNewPage extends AbstractPage {

    String id = "";


    private static final By titleText = By.id("title");
    private static final By contentText = By.id("content");
    private static final By addNewJsonButton = By.xpath("//button[@data-testid='someJson-add']");
    private static final By statusSelectionComboBox = By.xpath("//section[@data-testid='property-edit-status']//input");
    private static final By saveButton = By.xpath("//button[@type='submit']");
    private static final By statusMenuACTIVESelection = By.xpath("//section[@data-testid='property-edit-status']//div[contains(@id,'listbox')]//div//div[contains(@id,'option-0')]");
    private static final By statusMenuREMOVESelection = By.xpath("//section[@data-testid='property-edit-status']//div[contains(@id,'listbox')]//div//div[contains(@id,'option-1')]");
    private static final By publisherSelection = By.xpath("//section[@data-testid='property-edit-publisher']//div[contains(@class, 'container')]");
    private static final By publisherList = By.xpath("//section[@data-testid='property-edit-publisher']//div[contains(@class, 'container')]//div[contains(@id,'listbox')]");
    private static final By publishedCheckBox = By.xpath("//section[@data-testid='property-edit-published']//input[@id='published']//..//a");


    public PostCreateNewPage(WebDriver driver) {
        this.driver = driver;
        this.bot = new ActionBot(driver);
    }

    public void setTitleText(String title) {
        bot.writeToElement(title, titleText);
    }

    public void setContent(String content) {
        bot.writeToElement(content, contentText);
    }

    public void clickOnAddNewJsonButton() {
        bot.click(addNewJsonButton);
    }

    public PostPage clickOnSaveButton() {
        bot.click(saveButton);
        return new PostPage(driver);
    }

    public void setJsonNumber(String number, String jsonId) {
        WebElement jsonNum = driver.findElement(By.xpath("//div[@data-testid='property-edit-someJson']//div[@data-testid='" + jsonId + "']//section[contains(@data-testid,'" + jsonId + "')]//input[contains(@id,'number')]"));
        bot.writeToElement(number, jsonNum);
        bot.writeToElement(Keys.TAB, jsonNum);
    }

    public void setJsonString(String text, String jsonId) {
        WebElement jsonString = driver.findElement(By.xpath("//div[@data-testid='property-edit-someJson']//div[@data-testid='" + jsonId + "']//section[contains(@data-testid,'" + jsonId + "')]//input[contains(@id,'string')]"));
        bot.writeToElement(text, jsonString);
        bot.writeToElement(Keys.TAB, jsonString);
    }

    public void setJsonBoolean(boolean state, String jsonId) {
        By jsonBoolean = By.xpath("//div[@data-testid='property-edit-someJson']//div[@data-testid='" + jsonId + "']//section[contains(@data-testid,'" + jsonId + "')]//div//span//input[contains(@id,'boolean')]//..//a");

        if (state) {
            bot.click(jsonBoolean);
        }
    }

    public void setJsonElement(JsonData jsonData, int number) throws InterruptedException {
        String num = String.valueOf(number - 1);
        String jsonId = "someJson.".concat(num);


        setJsonNumber(jsonData.getSomeJsonNumber(), jsonId);
        setJsonString(jsonData.getSomeJsonString(), jsonId);

        setJsonBoolean(jsonData.isSomeJsonBoolean(), jsonId);
    }

    public void selectStatus(PostStatusSelection postStatusSelection) {
        bot.click(statusSelectionComboBox);

        switch (postStatusSelection) {
            case ACTIVE:
                bot.click(statusMenuACTIVESelection);
                break;
            case REMOVED:
                bot.click(statusMenuREMOVESelection);
                break;
        }
    }

    public void selectPublisher(String publisher) {
        bot.click(publisherSelection);

        WebElement list = driver.findElement(publisherList);

        List<WebElement> listOption = list.findElements(By.xpath("//*[contains(@id,'option')]"));

        for (WebElement item : listOption) {
            if (item.getText().equals(publisher)) {
                bot.click(item);
            }
        }

    }

    public void clickOnPublishedCheckBox(boolean shouldBeSelected) {
        String att = driver.findElement(publishedCheckBox).getAttribute("class");
        boolean isSelected = false;
        if (att.equals("sc-fsQiph jSSKKG")) isSelected = true;

        if ((shouldBeSelected && !isSelected) || (!shouldBeSelected && isSelected)) {
            bot.click(publishedCheckBox);
        }

    }

}


