package org.example.app.opertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/* Handle date pick - assumption for this test that the date is only in the later then today date*/
public  final class DatePicker {

    protected static WebDriver driver;


       public static void selectDate(WebDriver driver ,String monthAndYear, String day)
       {
            WebElement dateInput = driver.findElement(By.cssSelector(".react-datepicker__input-container input"));
            dateInput.click();

            // Wait for the date picker to be visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".react-datepicker")));

            // First, navigate to the correct year and month
            navigateToMonthAndYear(driver, monthAndYear);

            // Select the desired day
            WebElement dayElement = driver.findElement(By.xpath("//div[contains(@class, 'react-datepicker__day') and text()='"+ day+"']"));
            dayElement.click();
    }


    private static void navigateToMonthAndYear(WebDriver driver, String monthYear) {
        WebElement monthYearElement = driver.findElement(By.cssSelector(".react-datepicker__current-month"));
        while (!monthYearElement.getText().equals(monthYear)){
            WebElement nextButton = driver.findElement(By.cssSelector(".react-datepicker__navigation--next"));
            nextButton.click();
            monthYearElement = driver.findElement(By.cssSelector(".react-datepicker__current-month"));
        }
    }
}
