package org.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class Invalid_Login {

    String expectedText = "Your email, password, IP address or location did not match";
    @Test
    public void invalidLogin() throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(" https://app.vwo.com/");
        driver.findElement(By.id("login-username")).sendKeys("admin");
        driver.findElement(By.id("login-password")).sendKeys("admin");
        driver.findElement(By.id("js-login-btn")).click();
        Thread.sleep(5000);
        String actualText = driver.findElement(By.id("js-notification-box-msg")).getText();
        System.out.println(actualText);

        if (expectedText.equals(actualText)) {
            System.out.println("Message is matching");
        } else {
            System.out.println("Message is not matching");
        }
        driver.quit();


    }
}

