package org.selenium.Wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class IW {

    WebDriver driver;


    @BeforeTest

    public void openBrowser()
    {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://app.vwo.com/#/login");
    }

    @Test

    public void appTest()
    {
        //Implicit wait
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("login-username")).sendKeys("sachin123");
        driver.findElement(By.id("login-password")).sendKeys("wer");
        driver.findElement(By.id("js-login-btn")).click();
        //Explicit wait
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js-notification-box-msg")));
        WebElement element=driver.findElement(By.id("js-notification-box-msg"));
        System.out.println(element.getText());
    }

    @AfterTest

        public void closeBrowser()
    {
        driver.quit();

    }
}
