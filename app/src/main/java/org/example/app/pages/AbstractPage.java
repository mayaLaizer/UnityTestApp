package org.example.app.pages;

import org.example.app.utils.ActionBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {

    public WebDriver driver;
    public ActionBot bot;



    //Happy folder options
    protected static final By happyFolderDD = By.xpath("//div[text()='Happy Folder']");
    protected static final By publisherButton = By.xpath("//div[text()='Publisher']");
    protected static final By profileButton = By.xpath("//div[text()='Profile']");
    protected static final By postButton = By.xpath("//div[text()='Post']");

    //Create First and New button for post and Publisher pages
    protected static final By createFirstRecordButton = By.xpath("//button[@data-testid='action-new']");
    protected static final By createNewButton = By.xpath("//a[@data-css='Publisher-new-button']");
    protected static final By filterButton = By.xpath("Publisher-filter-button");

    //Edit and delete buttons for post and Publisher pages
    protected static final By editButton = By.xpath("//a[@data-testid='action-edit']");
    protected static final By deleteButton = By.xpath("//a[@data-testid='action-delete']");


    public AbstractPage() {

    }
}
