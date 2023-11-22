package org.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.get("https://app.vwo.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void validUser() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='login-username']"))
                .sendKeys("sachinocm23@gmail.com");

        driver.findElement(By.xpath("//input[@id='login-password']"))
                .sendKeys("Sachin@1");
        driver.findElement(By.xpath("//button[@id='js-login-btn']"))
                .click();
        Thread.sleep(5000);
       Assert.assertTrue(driver.findElement(By.cssSelector(".page-heading"))
      .isDisplayed());



    }

    @AfterMethod
    public void closeBrowser() {
        //driver.quit();
    }
}