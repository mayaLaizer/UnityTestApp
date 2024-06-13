package org.example.app.pages;

import org.example.app.utils.ActionBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/* Login Page Object to perform login*/
public class LoginPage extends AbstractPage {

    private static final By loginButton = By.xpath("//button[text()='Login']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.bot = new ActionBot(driver);
    }

    public MainPage clickOnLoginButton()
    {
        bot.click(loginButton);
        return new MainPage(driver);
    }
}
