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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VWO_Login {

    WebDriver driver;

    @BeforeTest
    public void openBrowser() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://app.vwo.com/#/login");

    }

    @Test
    @Owner("Sachin Chauhan")
    @Severity(SeverityLevel.CRITICAL)
    @Description("TC01:Verify the error message invalid username or password")
    public void negative_Testcase() throws InterruptedException {
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@data-qa='hocewoqisi']")).sendKeys("ab@gmail.com");
        driver.findElement(By.id("login-password")).sendKeys("123");
        driver.findElement(By.id("js-login-btn")).click();
        Thread.sleep(10000);
        WebElement error_message = driver.findElement(By.id("js-notification-box-msg"));
        System.out.println(error_message.getText());
        Assert.assertEquals(error_message.getText(), "Your email, password, IP address or location did not match");

    }

    @Test
    @Owner("Sachin Chauhan")
    @Severity(SeverityLevel.CRITICAL)
    @Description("TC02:Verify the name is displayed on dashboard valid username or password")

    public void positive_TestCase() throws InterruptedException {
        driver.manage().window().maximize();
        WebElement username = driver.findElement(By.xpath("//input[@data-qa='hocewoqisi']"));
        username.clear();
        username.sendKeys("sachinocm23@gmail.com");
        WebElement password = driver.findElement(By.id("login-password"));
        password.clear();
        password.sendKeys("Sachin@1");
        driver.findElement(By.id("js-login-btn")).click();
        Thread.sleep(10000);
        WebElement element = driver.findElement(By.xpath("//span[@data-qa='lufexuloga']"));
        System.out.println(element.getText());
        Assert.assertEquals(element.getText(), "SACHIN Chauhan");
    }

    @AfterTest

    public void closeBrowser() {
        driver.quit();
    }


}
