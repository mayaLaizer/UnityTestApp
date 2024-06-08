package org.example.app.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionBot {

    private final WebDriver driver;


    public ActionBot(WebDriver driver) {
        this.driver = driver;
    }


    public void click(By elementLocator) {

        try {
            WebElement element = driver.findElement(elementLocator);
            waitForElementToBeClickable(element);
            element.click();
        } catch (NoSuchElementException e) {
            System.out.println("No Such Element:"+ elementLocator);
        }
    }
    public void click(WebElement elem) {

        try {

            waitForElementToBeClickable(elem);
            elem.click();
        } catch (NoSuchElementException e) {
            System.out.println("No Such Element:"+ elem);
        }
    }


    public void jsClick(By elementLocator)
    {

        try {
            WebElement element = driver.findElement(elementLocator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click;", element);
        } catch (NoSuchElementException e) {
            System.out.println("No Such Element:"+ elementLocator);
        }

    }

    public void writeToElement(String text, By elementLocator)
    {
        try {
            WebElement element = driver.findElement(elementLocator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].value ='';", element);
            element.sendKeys(text);
        } catch (NoSuchElementException e) {
            System.out.println("No Such Element:"+ elementLocator);
        }
    }

    public void writeToElement(String text, WebElement elem)
    {
        try {

            ((JavascriptExecutor) driver).executeScript("arguments[0].value ='';", elem);
            elem.sendKeys(text);
        } catch (NoSuchElementException e) {
            System.out.println("No Such Element:"+ elem);
        }
    }
    public void writeToElement(Keys key,By elementLocator)
    {
        try {
            WebElement element = driver.findElement(elementLocator);
            element.sendKeys(key);
        } catch (NoSuchElementException e) {
            System.out.println("No Such Element:"+ elementLocator);
        }

    }

    public void writeToElement(Keys key,WebElement elem)
    {
        try {

            elem.sendKeys(key);
        } catch (NoSuchElementException e) {
            System.out.println("No Such Element:"+ elem);
        }

    }

    public String getElementText(By elementLocator) {

        try {
            WebElement element = driver.findElement(elementLocator);
            String text = element.getText();
            return text;
        } catch (NoSuchElementException e) {
            System.out.println("No Such Element:"+ elementLocator);
        }
        return null;
    }

    public void waitForElementToBeClickable(WebElement element, int secondsToWait) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(secondsToWait));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementPresent(WebElement element, int secondsToWait)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(secondsToWait));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeClickable(WebElement element) {
        waitForElementToBeClickable(element, 10);
    }

    public boolean isElementDisplay(By elementLocator)
    {
        WebElement element = driver.findElement(elementLocator);
        return element.isDisplayed();

    }
    public void mouseOver(By elementLocator)
    {
        WebElement element = driver.findElement(elementLocator);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();

    }

}
