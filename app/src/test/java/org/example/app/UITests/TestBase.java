package org.example.app.UITests;

import org.example.app.pages.LoginPage;
import org.example.app.pages.MainPage;
import org.example.app.pages.Post.DeletePostPage;
import org.example.app.pages.Post.PostPage;
import org.example.app.pages.publisher.DeletePublisherPage;
import org.example.app.pages.publisher.PublisherPage;
import org.example.app.utils.ActionBot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


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


    protected LoginPage navToLoginPage() {
        driver.get("http://localhost:3000/admin");
        return new LoginPage(driver);
    }

    protected PublisherPage navToPublisherPage() {
        driver.get("http://localhost:3000/admin/resources/Publisher");
        return new PublisherPage(driver);

    }

    protected PostPage navToPostPage() {
        driver.get("http://localhost:3000/admin/resources/Post");
        return new PostPage(driver);

    }


    public void cleanUP() throws InterruptedException {
        Thread.sleep(100); //wait for all the pop ups disappear
        MainPage mainPage = new MainPage(driver);

        PostPage postPage = mainPage.clickOnPostButton();
        postPage.selectPostRaw("Title");

        DeletePostPage deletePostPage = postPage.clickOnDeleteAllButton();
        deletePostPage.clickOnConfirmRemovalButton();

        PublisherPage publisherPage = mainPage.clickOnPublisherButton();
        publisherPage.selectPublisherRaw("Name");
        DeletePublisherPage deletePublisherPage = publisherPage.clickOnDeleteAllButton();
        Thread.sleep(100);
        deletePublisherPage.clickOnConfirmRemovalButton();

    }


    @AfterClass
    public void afterClass() throws InterruptedException {

        cleanUP();
        driver.quit();
    }
}
