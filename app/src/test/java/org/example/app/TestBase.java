package org.example.app;

import org.example.app.pages.LoginPage;
import org.example.app.pages.MainPage;
import org.example.app.pages.publisher.PublisherPage;
import org.example.app.utils.ActionBot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestBase {

    public static ChromeOptions chromeOptions;
    public static WebDriver driver;

      public static ActionBot bot;


    @BeforeClass
    public void beforeClass() {
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        navToLoginPage();

    }



    protected LoginPage navToLoginPage(){
        driver.get("http://localhost:3000/admin");
        return new LoginPage(driver);
    }



    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
