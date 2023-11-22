package org.selenium;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium02 {

    @Owner("Sachin")
    @Severity(SeverityLevel.CRITICAL)
    @Description("TC#1:Verify the error message with invalid username or password")

    @Test

    public void negative_TestCase() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://app.vwo.com/#/login");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.id("login-username")).sendKeys("ab@gmail.com");
        driver.findElement(By.id("login-password")).sendKeys("1234");
        driver.findElement(By.id("js-login-btn")).click();
        Thread.sleep(3000);
        WebElement Error_msg = driver.findElement(By.id("js-notification-box-msg"));
        System.out.println(Error_msg.getText());
        driver.quit();
        //Assert.assertEquals(Error_msg.getText(), "Your email, password, IP address or location did not match");


    }
}
