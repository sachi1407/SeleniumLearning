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

public class Verify_Dashboard {

    @Owner("Sachin")
    @Description("TC#2:Verify the dashboard page")
    @Severity(SeverityLevel.CRITICAL)

    @Test
    public void dashboard() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com/#/login");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.findElement(By.id("login-username")).sendKeys("sachinocm23@gmail.com");
        driver.findElement(By.id("login-password")).sendKeys("Sachin@1");
        driver.findElement(By.id("js-login-btn")).click();
        Thread.sleep(10000);
        WebElement element = driver.findElement(By.xpath("//span[@data-qa='lufexuloga']"));
        System.out.println(element.getText());
        Assert.assertEquals(element.getText(), "SACHIN Chauhan");
        driver.findElement(By.xpath("//img[@data-qa='user-image']")).click();
        driver.findElement(By.xpath("//li[@data-qa='logout-btn']")).click();
        driver.quit();


    }
}
