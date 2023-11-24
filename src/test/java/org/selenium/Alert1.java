package org.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;

public class Alert1 {

    WebDriver driver;

    @BeforeTest
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
    }

    @Test

    public void testAlert() {


        //driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        //Alert al=driver.switchTo().alert();
        //al.accept();

        //driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        // Alert al = driver.switchTo().alert();
        // al.dismiss();
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
        //WebElement message = driver.findElement(By.id("result"));
        //  System.out.println(message.getText());

        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Sachin");
        alert.accept();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
        WebElement message = driver.findElement(By.id("result"));
        System.out.println(message.getText());


    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
